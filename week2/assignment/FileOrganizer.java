import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class FileOrganizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter file names with extensions (e.g., resume.docx, photo.jpg):");
        System.out.println("Type 'done' to finish.");

        List<String> fileNames = new ArrayList<>();
        String input;
        while (!(input = scanner.nextLine()).equalsIgnoreCase("done")) {
            fileNames.add(input);
        }
        scanner.close();

        List<FileEntry> files = new ArrayList<>();
        for (String fileName : fileNames) {
            files.add(new FileEntry(fileName));
        }

        System.out.println("\n--- File Organization Report ---");
        System.out.printf("%-25s | %-15s | %-30s | %s%n", "Original Name", "Category", "New Name", "Subcategory");
        System.out.println("-------------------------------------------------------------------------------------");

        Map<String, Integer> categoryCounts = new HashMap<>();
        List<String> unknownFiles = new ArrayList<>();

        for (FileEntry file : files) {
            file.analyze();
            categoryCounts.put(file.category, categoryCounts.getOrDefault(file.category, 0) + 1);
            if (file.category.equals("Unknown")) {
                unknownFiles.add(file.originalName);
            }

            System.out.printf("%-25s | %-15s | %-30s | %s%n", 
                file.originalName, file.category, file.newName, file.subCategory);
        }

        System.out.println("\n--- Category Summary ---");
        for (Map.Entry<String, Integer> entry : categoryCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " files");
        }
        
        System.out.println("\n--- Batch Rename Commands ---");
        for (FileEntry file : files) {
            if (!file.originalName.equals(file.newName)) {
                System.out.println("ren \"" + file.originalName + "\" \"" + file.newName + "\"");
            }
        }
    }

    static class FileEntry {
        String originalName;
        String fileName;
        String extension;
        String category;
        String subCategory = "N/A";
        String newName;

        public FileEntry(String originalName) {
            this.originalName = originalName;
            extractComponents();
        }

        private void extractComponents() {
            int dotIndex = originalName.lastIndexOf('.');
            if (dotIndex > 0) {
                this.fileName = originalName.substring(0, dotIndex);
                this.extension = originalName.substring(dotIndex + 1);
            } else {
                this.fileName = originalName;
                this.extension = "";
            }
        }

        public void analyze() {
            this.category = categorizeByExtension(this.extension);
            this.subCategory = analyzeContent(this.fileName, this.category);
            this.newName = generateNewName(this.fileName, this.extension, this.category);
        }

        private String categorizeByExtension(String ext) {
            if (ext.equalsIgnoreCase("txt") || ext.equalsIgnoreCase("doc") || ext.equalsIgnoreCase("docx")) {
                return "Documents";
            }
            if (ext.equalsIgnoreCase("jpg") || ext.equalsIgnoreCase("png") || ext.equalsIgnoreCase("gif")) {
                return "Images";
            }
            if (ext.equalsIgnoreCase("mp3") || ext.equalsIgnoreCase("wav")) {
                return "Audio";
            }
            if (ext.equalsIgnoreCase("mp4") || ext.equalsIgnoreCase("avi")) {
                return "Videos";
            }
            return "Unknown";
        }

        private String analyzeContent(String name, String category) {
            String lowerName = name.toLowerCase();
            if (category.equals("Documents")) {
                if (lowerName.contains("resume") || lowerName.contains("cv")) {
                    return "Resume";
                }
                if (lowerName.contains("report") || lowerName.contains("project")) {
                    return "Report";
                }
            }
            if (category.equals("Images")) {
                if (lowerName.contains("vacation") || lowerName.contains("trip")) {
                    return "Travel";
                }
            }
            return "General";
        }

        private String generateNewName(String name, String ext, String category) {
            StringBuilder newNameBuilder = new StringBuilder();
            newNameBuilder.append(category.toLowerCase()).append("_");
            newNameBuilder.append(System.currentTimeMillis()).append(".");
            newNameBuilder.append(ext);
            return newNameBuilder.toString();
        }
    }
}