package view;

import controller.MapController;
import controller.TechController;
import controller.UsersController;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.Maps;
import model.Settler;
import model.Tile;
import model.User;
import view.enums.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GameEnvironment {
    private UsersController users;
    private MediaPlayer mediaPlayer;
    private Stage stage;
    private AnchorPane root;
    private AnchorPane finalRoot;
    private static Images images;
    private User user;
    private Maps map;
    private ArrayList<User> players;
    private HashMap<ImageView, Object> imageViewObjects;

    public GameEnvironment(MediaPlayer mediaPlayer, Stage stage, Images images, UsersController users, User user, ArrayList<User> players){
        this.users = users;
        GameEnvironment.images = images;
        this.mediaPlayer = mediaPlayer;
        this.stage = stage;
        this.user = user;
        map = users.readFromJsonMap();
        finalRoot = new AnchorPane();
        this.players = players;
        imageViewObjects = new HashMap<>();
    }

    public GameEnvironment(){}

    public void run(){
        root = new AnchorPane();
        finalRoot.getChildren().add(root);
        finalRoot.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Scene scene = new Scene(finalRoot, 10, 5);
        scene.setRoot(finalRoot);
        stage.setScene(scene);
        root.getStylesheets().add(String.valueOf(getClass().getResource("/CSS/Style.css")));
        stage.setMaximized(true);
        stage.setFullScreen(true);
        MapController.getInstance(map).firstSetOfSettlers(players);
        createMap();
    }

    private void createMap(){
        HashMap<ImageView, Boolean> canPopup = new HashMap<>();
        int i = 1;
        for (Tile[] tiles : map.getTileBoard()) {
            for (Tile tile : tiles) {
                Image TileTerrainImage = findCell(tile);
                if (TileTerrainImage == images.mountainCell && tile.getY() % 2 == 0) TileTerrainImage = images.mountainCell2;
                if (TileTerrainImage !=  null) {
                    ImageView imageView = new ImageView(TileTerrainImage);
                    imageView.setLayoutX(tile.getY() * 285 - tile.getX() % 2 * 142.5);
                    imageView.setFitWidth(285);
                    imageView.setLayoutY(tile.getX() * 360 - tile.getX() * 95);
                    imageView.setFitHeight(360);
                    imageView.setId("Tile");
                    imageViewObjects.put(imageView, tile);
                    canPopup.put(imageView, true);
                    root.getChildren().add(imageView);

                    resourceHandler(tile, imageView);
                    showUnits(tile, imageView);
                    tileMouseClickHandle(tile, imageView, canPopup);

                } else {
                    System.out.println( i + " : An error happened! -> GameEnvironment -> createMap : " + tile.getTerrain().getName());
                    i++;
                }
            }
        }
        new Thread(this::mouseClickHandler).start();
        scrollHandler();
    }

    private Image findCell(Tile tile) {
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Jungle")) return images.jungleCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Forest")) return images.forestCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Ice")) return images.iceCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Marsh")) return images.marshCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("FloodPlain")) return images.floodPlainCell;
        if (tile.getFeature() != null && tile.getFeature().getName().equals("Oasis")) return images.oasisCell;
        return switch (tile.getTerrain().getName()) {
            case "Desert" -> images.desertCell;
            case "Grassland" -> images.grasslandCell;
            case "Hill" -> images.hillCell;
            case "Ocean" -> images.oceanCell;
            case "Plain" -> images.plainCell;
            case "Snow" -> images.snowCell;
            case "Tundra" -> images.tundraCell;
            case "Mountain" -> images.mountainCell;
            default -> null;
        };
    }

    private Image findResource(Tile tile) {
        if (tile.getResource() == null)return null;
        return switch (tile.getResource().getName()) {
            case "Banana" -> images.banana;
            case "Cow" -> images.cow;
            case "Gazelle" -> images.deer;
            case "Wheat" -> images.wheat;
            case "Sheep" -> images.sheep;
            case "Coal" -> images.coal;
            case "Horse" -> images.horse;
            case "Iron" -> images.iron;
            case "Cotton" -> images.cotton;
            case "Color" -> images.color;
            case "Fur" -> images.fur;
            case "Gemstones" -> images.gemStone;
            case "Gold" -> images.goldResource;
            case "Fumigation" -> images.fumigation;
            case "Silk" -> images.silk;
            case "Sugar" -> images.sugar;
            case "Silver" -> images.silver;
            case "Marble" -> images.marble;
            case "Ivory" -> images.ivory;
            default -> null;
        };
    }

    private void showPopupInfo(Rectangle rectangle, Tile tile, Label label,
                               ImageView foodView, ImageView goldView, ImageView productionView) {
        int food = 0;
        int production = 0;
        int gold = 0;
        if (tile.getFeature() != null) {
            food += tile.getFeature().getFoodRate();
            gold += tile.getFeature().getGoldRate();
            production += tile.getFeature().getProductionRate();
        }
        food += tile.getTerrain().getFoodRate();
        gold += tile.getTerrain().getGoldRate();
        production += tile.getTerrain().getProductionRate();
        String labelText;
        if (tile.getFeature() == null) labelText = "Terrain : " + tile.getTerrain().getName() + "\n\n"
                + food + "\n" + gold + "\n" + production;
        else labelText = "Terrain : " + tile.getTerrain().getName() + "\n" + "Feature : " + tile.getFeature().getName() + "\n"
                + food + "\n" + gold + "\n" + production;
        label.setText(labelText);
        label.setLayoutX(rectangle.getX() + 32);
        label.setLayoutY(rectangle.getY() + 3);
        label.getStyleClass().add("popup-info-text");

        foodView.setImage(images.food);
        foodView.setFitHeight(20);
        foodView.setFitWidth(20);
        foodView.setLayoutX(label.getLayoutX() - 25);
        foodView.setLayoutY(label.getLayoutY() + 52);

        goldView.setImage(images.gold);
        goldView.setFitHeight(20);
        goldView.setFitWidth(20);
        goldView.setLayoutX(label.getLayoutX() - 25);
        goldView.setLayoutY(label.getLayoutY() + 77);

        productionView.setImage(images.production);
        productionView.setFitHeight(20);
        productionView.setFitWidth(20);
        productionView.setLayoutX(label.getLayoutX() - 25);
        productionView.setLayoutY(label.getLayoutY() + 102);

        root.getChildren().add(foodView);
        root.getChildren().add(goldView);
        root.getChildren().add(productionView);
        root.getChildren().add(label);
    }

    private void resourceHandler(Tile tile, ImageView imageView) {
        Image TileResourceImage = findResource(tile);
        if(TileResourceImage != null) {
            ImageView resourceView = new ImageView(TileResourceImage);
            resourceView.setLayoutX(imageView.getLayoutX() + 25);
            resourceView.setLayoutY(imageView.getLayoutY() + 60);
            resourceView.setFitWidth(90);
            resourceView.setFitHeight(90);
            resourceView.setId("Resource");
            imageViewObjects.put(resourceView, tile.getResource());
            root.getChildren().add(resourceView);
        }
    }

    private void tileMouseClickHandle(Tile tile, ImageView imageView, HashMap<ImageView, Boolean> canPopup) {
        imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            double popupX;
            double popupY;
            if (tile.getY() > 77) popupX = imageView.getLayoutX() - 50;
            else popupX = imageView.getLayoutX() + 240;
            if (tile.getX() > 2) popupY = imageView.getLayoutY() - 125;
            else  popupY = imageView.getLayoutY() + 330;
            Rectangle rectangle = new Rectangle(popupX, popupY, 200, 132);
            rectangle.setFill(new Color(0, 0, 0, 0.6));
            Label label = new Label();
            ImageView foodView = new ImageView();
            ImageView goldView = new ImageView();
            ImageView productionView = new ImageView();
            if (canPopup.get(imageView)) {
                canPopup.replace(imageView, false);
                root.getChildren().add(rectangle);
                showPopupInfo(rectangle, tile, label, foodView, goldView, productionView);
            }
            if (tile.getCivilianUnit() != null && tile.getCivilianUnit().getName().equals("settler")){
                createCity(tile, imageView);
            }
            imageView.addEventHandler(MouseEvent.MOUSE_EXITED, event -> {
                root.getChildren().remove(rectangle);
                root.getChildren().remove(label);
                root.getChildren().remove(foodView);
                root.getChildren().remove(goldView);
                root.getChildren().remove(productionView);
                canPopup.replace(imageView, true);
            });
        });
    }

    private void scrollHandler() {
        root.setOnScroll(event -> {
            if (event.isControlDown()) {
                if (root.getScaleX() + event.getDeltaY() / 1000 > 0.165 && root.getScaleX() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleX(root.getScaleX() + event.getDeltaY() / 1000);
                if (root.getScaleY() + event.getDeltaY() / 1000 > 0.165 && root.getScaleY() + event.getDeltaY() / 1000 <= 1)
                    root.setScaleY(root.getScaleY() + event.getDeltaY() / 1000);
            } else {
                root.setTranslateX(root.getTranslateX() + event.getDeltaX());
                root.setTranslateY(root.getTranslateY() + event.getDeltaY());
            }
        });
    }

    //TODO : -GRAPHIC- DEBUG
    private void showUnits(Tile tile, ImageView imageView) {
        if (tile.getMilitaryUnit() != null) {
            Image MUnit = findMUnit(tile);
            ImageView MUitView = new ImageView(MUnit);
            MUitView.setLayoutX(imageView.getLayoutX() + 25);
            MUitView.setLayoutY(imageView.getLayoutY() + 300);
            MUitView.setFitHeight(90);
            MUitView.setFitWidth(90);
            MUitView.setId(tile.getMilitaryUnit().getName());
            imageViewObjects.put(MUitView, tile.getMilitaryUnit());
            root.getChildren().add(MUitView);
        }

        if (tile.getCivilianUnit() != null) {
            Image CUnit = findCUnit(tile);
            ImageView CUnitView = new ImageView(CUnit);
            CUnitView.setLayoutX(imageView.getLayoutX() + 180);
            CUnitView.setLayoutY(imageView.getLayoutY() + 155);
            CUnitView.setFitHeight(150);
            CUnitView.setFitWidth(150);
            CUnitView.setId(tile.getCivilianUnit().getName());
            imageViewObjects.put(CUnitView, tile.getCivilianUnit());
            root.getChildren().add(CUnitView);
        }
    }

    private Image findMUnit(Tile tile) {
        return switch (tile.getMilitaryUnit().getName()) {
            case "Chariot Archer" -> images.chariotArcher;
            case "Spearman" -> images.spearman;
            case "Horseman" -> images.horseman;
            case "Swordsman" -> images.swordMan;
            case "Catapult" -> images.catapult;
            case "Knight" -> images.knight;
            case "Pikeman" -> images.pikeMan;
            case "Crossbowman" -> images.crossbowman;
            case "Trebuchet" -> images.trebuchet;
            case "Longswordsman" -> images.longSwordsman;
            case "Musketman" -> images.musketMan;
            case "Lancer" -> images.lancer;
            case "Cavalry" -> images.cavalry;
            case "Rifleman" -> images.rifleMan;
            case "Tank" -> images.tank;
            case "Panzer" -> images.panzer;
            case "Artillery" -> images.artillery;
            case "Infantry" -> images.infantry;
            case "Anti-Tank Gun" -> images.antiTankGun;
            case "warrior" -> images.warrior;
            case "Canon" -> images.canon;
            default -> null;
        };
    }

    private Image findCUnit(Tile tile) {
        if (tile.getCivilianUnit() == null) return null;
        return switch (tile.getCivilianUnit().getName()) {
            case "worker" -> images.worker;
            case "settler" -> images.settler;
            case "scout" -> images.scout;
            default -> null;
        };
    }

    //TODO : -GRAPHIC-LOGIC- DEBUG
    //TODO : -LOGIC- ADD THIS TO CREATE MAP
    private void createCity(Tile tile, ImageView imageView) {
        if (tile.getCity() != null) {
            ImageView cityView = new ImageView(images.city);
            cityView.setLayoutX(imageView.getLayoutX() + 50);
            cityView.setLayoutY(imageView.getLayoutY() + 65);
            cityView.setFitWidth(200);
            cityView.setFitHeight(200);
            root.getChildren().add(cityView);
        }
    }

    private void mouseClickHandler() {
        UnitClickAction unitClickAction = new UnitClickAction(finalRoot, images);
        imageViewObjects.forEach((imageView, object) -> {
            if (imageView.getId().equals("settler")) imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
                unitClickAction.setUnit((Settler) object);
                unitClickAction.settlerClickAction();
            });
        });
    }

}
