package view;

import controller.TechController;
import model.Improvement;
import model.Technology;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ResearchMenu {

    private TechController techController;

    public ResearchMenu(TechController techController) {
        this.techController = techController;
    }

    public void run(Scanner scanner, User user) {
        String researchInput;
        if (user.getTechnologies() != null) {
            System.out.println("player has done this technologies");
            for (Technology technology : user.getTechnologies()) {
                System.out.println(technology.getName());
            }
        }
        while (true) {
            researchInput = scanner.nextLine();
            if (researchInput.equals("research exit"))
                return;
            else if (researchInput.equals("select technology")) {
                selectTech(user, scanner);
            }
            else if (researchInput.equals("show tree of technologies")) {
                showTree(user, scanner);
            }
        }
    }

    public void selectTech(User user, Scanner scanner) {

        ArrayList<Technology> technologies = techController.getUserResearches(user);
        int index = 1;
        for (Technology technology : technologies) {
            System.out.println(index + "- " + technology.getName());
            if (technology.getGivenImprovement() != null) {
                System.out.println("given improvements : ");
                for (Improvement improvement : technology.getGivenImprovement())
                    System.out.println("name: " + improvement.getName() + " | production: " + improvement.getProductionRate() + " | food: " + improvement.getFoodRate() + " | gold: " + improvement.getGoldRate());

            }
        }
        System.out.println("choose an index | <tech exit> to get out");
        String techInput;
        while (true) {
            techInput = scanner.nextLine();
            if (techInput.trim().equals("tech exit"))
                return;
            else if (Pattern.matches("[\\d+]", techInput)) {
                index = Integer.parseInt(techInput);
                if (index >= 1 && index <= technologies.size()) {
                    // choose the tech and research on it
                    user.setResearching(true);
                    user.setCurrentTechnology(technologies.get(index));
                    user.setResearchTurnLeft(technologies.get(index).getSciencePrice());
                }
                else
                    System.out.println("invalid number");
            }
            else
                System.out.println("invalid command");
        }
    }

    private void showTree(User user, Scanner scanner) {
        ArrayList<Technology> prerequisites;
        System.out.println("**********");
        for (Technology ancientTechnology : techController.getAncientTechnologies()) {
            System.out.println(ancientTechnology.getName());
            prerequisites = techController.getPrerequisitesAncientTech(ancientTechnology);
            if (prerequisites != null) {
                System.out.println("prerequisites :");
                for (Technology prerequisite : prerequisites) {
                    System.out.println(prerequisite.getName());
                }
            }
            else
                System.out.println("this technology do not have any prerequisites");
            System.out.println("**********");
        }
    }
}
