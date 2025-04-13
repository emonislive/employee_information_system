package com.mycompany.randomdatagenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class RandomDataGenerator {

    public static void main(String[] args) {
        generateRandomData(100000);
    }

    public static void generateRandomData(int numEntries) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("input.txt"))) {
            Random random = new Random();

            // Arrays of sample data for descriptions, categories, first names, and last names
            String[] descriptions = {"Manager", "Engineer", "Sales Representative", "Accountant", "HR Specialist",
                    "Marketing Analyst", "Software Developer", "Data Analyst", "Graphic Designer", "Financial Analyst",
                    "Project Manager", "Customer Service Representative", "Operations Manager", "Administrative Assistant",
                    "Quality Assurance Analyst", "Business Analyst", "Human Resources Manager", "Product Manager",
                    "Network Administrator", "Web Developer", "Systems Analyst", "Digital Marketing Specialist",
                    "Executive Assistant", "Technical Support Specialist", "Social Media Manager", "Content Writer",
                    "IT Manager", "Event Coordinator", "Sales Manager", "Supply Chain Manager", "Executive Director",
                    "Marketing Coordinator", "Database Administrator", "Public Relations Specialist", "Software Engineer",
                    "Operations Coordinator", "Account Executive", "Financial Planner", "Marketing Manager", "Legal Assistant",
                    "Research Analyst", "Customer Success Manager", "Executive Chef", "Interior Designer", "Recruiter",
                    "Real Estate Agent", "Business Development Manager", "Financial Controller"};

            String[] categories = {"Category1", "Category2", "Category3", "Category4", "Category5", "Category6",
                    "Category7", "Category8", "Category9", "Category10", "Category11", "Category12", "Category13",
                    "Category14", "Category15", "Category16", "Category17", "Category18", "Category19", "Category20",
                    "Category21", "Category22", "Category23", "Category24", "Category25", "Category26", "Category27",
                    "Category28", "Category29", "Category30", "Category31", "Category32", "Category33", "Category34",
                    "Category35", "Category36", "Category37", "Category38", "Category39", "Category40", "Category41",
                    "Category42", "Category43", "Category44", "Category45", "Category46", "Category47", "Category48",
                    "Category49", "Category50"};

            String[] firstNames = {"John", "Jane", "Michael", "Emily", "David", "Sarah", "Daniel", "Jessica", "Chris",
                    "Laura", "Matthew", "Olivia", "Andrew", "Sophia", "James", "Ava", "Ryan", "Chloe", "William",
                    "Mia", "Ethan", "Amelia", "Alexander", "Harper", "Jacob", "Ella", "Nicholas", "Grace",
                    "Benjamin", "Lily", "Samuel", "Zoe", "Gabriel", "Natalie", "Daniel", "Avery", "Joseph",
                    "Hannah", "Luke", "Samantha", "Henry", "Elizabeth", "Owen", "Victoria", "Jackson", "Madison"};

            String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
                    "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson",
                    "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
                    "Allen", "Young", "Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams",
                    "Baker", "Gonzalez", "Nelson", "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips",
                    "Campbell", "Parker", "Evans"};

            // Generate numEntries random data entries
            for (int i = 0; i < numEntries; i++) {
                String name = firstNames[random.nextInt(firstNames.length)] + " " +
                        lastNames[random.nextInt(lastNames.length)];
                int value = random.nextInt(100000) + 50000; // Random value between 50000 and 149999
                String description = descriptions[random.nextInt(descriptions.length)];
                String createdAt = getRandomDateTime();
                String updatedAt = getRandomDateTime();
                String status = "active";
                String category = categories[random.nextInt(categories.length)];

                String entry = String.format("('%s', '%d', '%s', '%s', '%s', '%s', '%s'),",
                        name, value, description, createdAt, updatedAt, status, category);
                writer.println(entry);
            }
            System.out.println("Data generation completed successfully!");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to generate a random datetime string in the format "yyyy-MM-dd HH:mm:ss"
    public static String getRandomDateTime() {
        Random random = new Random();
        int year = 2020 + random.nextInt(5); // Random year between 2020 and 2024
        int month = random.nextInt(12) + 1; // Random month between 1 and 12
        int day = random.nextInt(28) + 1; // Random day between 1 and 28 (assuming all months have 28 days)
        int hour = random.nextInt(24); // Random hour between 0 and 23
        int minute = random.nextInt(60); // Random minute between 0 and 59
        int second = random.nextInt(60); // Random second between 0 and 59

        return String.format("%d-%02d-%02d %02d:%02d:%02d", year, month, day, hour, minute, second);
    }
}
