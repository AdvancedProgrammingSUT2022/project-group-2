package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GameController {

    private static GameController gameController;

    private final int height;
    private final int width;
    private ArrayList<User> players;


    private GameController() {
        this.height = 26;
        this.width = 80;
        players = new ArrayList<>();
    }

    public static GameController getInstance() {
        if (gameController == null)
            gameController = new GameController();
        return gameController;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }

    // cheat codes
    public void increaseTurn(int extraTurn, User specificPlayer) {
        specificPlayer.setTurns(specificPlayer.getTurns() + extraTurn);
    }

    public void increaseGold(int extraGold, User specificPlayer) {
        specificPlayer.setGold(specificPlayer.getGold() + extraGold);
    }

    public void increaseHappiness(int extraHappiness, User specificPlayer) {
        specificPlayer.setHappiness(specificPlayer.getHappiness() + extraHappiness);
    }

    public void increaseFood(int extraFood, User specificPlayer) {
        specificPlayer.setFood(specificPlayer.getFood() + extraFood);
    }

    public void increaseFaith(int extraFaith, User specificPlayer) {
        specificPlayer.setFaith(specificPlayer.getFaith() + extraFaith);
    }

    public void increaseScience(int extraScience, User specificPlayer) {
        specificPlayer.setScience(specificPlayer.getScience() + extraScience);
    }

    public void increaseCapitalCitizens(int extraCitizens, User specificPlayer) {
        specificPlayer.getCapital().setCitizensNumber(specificPlayer.getCapital().getCitizensNumber() + extraCitizens);
    }

    public void increaseCapitalDefence(int extraDefence, User specificPlayer) {
        specificPlayer.getCapital().setDefence(specificPlayer.getCapital().getDefence() + extraDefence);
    }

    public void increaseCulture(int extraCulture, User specificPlayer) {
        specificPlayer.setCulture(specificPlayer.getCulture() + extraCulture);
    }

    public void decreaseResearchTurnLeft(int extraResearch, User specificPlayer) {
        specificPlayer.setResearchTurnLeft(specificPlayer.getResearchTurnLeft()- extraResearch);
    }
/*
    // find the tile by given x and y coordinates
    public Tile findTile(int x, int y) {
        if (x < height && y < width)
            return map.getTileBoard()[x][y];
        return null;
    }
*/
    public void moveUnit(Tile origin, Tile destination, Unit unit, boolean isMilitary) {
        if (isMilitary)
            moveMilitary(origin, destination, (MilitaryUnit) unit);
        else
            moveCivilian(origin, destination, (Civilian) unit);
    }

    private void moveMilitary(Tile origin, Tile destination, MilitaryUnit militaryUnit) {
        militaryUnit.setTile(destination);
        origin.setMilitaryUnit(null);
        origin.setMilitaryUnitExists(false);
        destination.setMilitaryUnit(militaryUnit);
        destination.setMilitaryUnitExists(true);
    }

    private void moveCivilian(Tile origin, Tile destination, Civilian civilian) {
        civilian.setTile(destination);
        origin.setCivilianUnit(null);
        origin.setCivilianUnitExists(false);
        destination.setCivilianUnit(civilian);
        destination.setCivilianUnitExists(true);
    }
/*
    public void cityTurnProducts(User user) {
        // for each on user's cities
        if (user.getCities() != null) {
            for (City city : user.getCities()) {
                // if producing production
                if (city.isProductStatus()) {
                    // if product is done
                    if (city.getProductTurnLeft() <= 1) {
                        city.setProductTurnLeft(0);
                        findProduction(city, city.getCurrentProduction());
                        city.setCurrentProduction(null);
                        city.setProductStatus(false);
                    } else
                        city.setProductTurnLeft(city.getProductTurnLeft() - 1);
                }
            }
        }
    }*/
/*
    public void userTurnResearch(User user) {
        if (user.isResearching()) {
            // if research is done
            if (user.getResearchTurnLeft() <= 1) {
                //notification for research
                UserPanel.researchDoneNotification(user, user.getCurrentTechnology());
                user.setResearching(false);
                user.setResearchTurnLeft(0);
                user.addTechnology(user.getCurrentTechnology());
                // add given improvements to user's arraylist of improvements
                if (user.getCurrentTechnology().getGivenImprovement() != null) {
                    for (Improvement improvement : user.getCurrentTechnology().getGivenImprovement()) {
                        user.addImprovement(improvement);
                    }
                }
                // add given units to possible products of the city
                if (user.getCurrentTechnology().getGivenUnits() != null) {
                    MeleeMilitaryUnit meleeMilitaryUnit;
                    RangeMilitaryUnit rangeMilitaryUnit;
                    for (Unit givenUnit : user.getCurrentTechnology().getGivenUnits()) {
                        for (City city : user.getCities()) {
                            // range military unit
                            if (givenUnit.getRangeCombatStrength() > 0) {
                                rangeMilitaryUnit = new RangeMilitaryUnit(givenUnit.getName(), null, givenUnit.getHP(), givenUnit.getGoldPrice(), givenUnit.getProductionPrice(), givenUnit.getLevel(), givenUnit.getMP(), givenUnit.getCombatStrength(), givenUnit.getRangeCombatStrength(), city.getOwner(), givenUnit.getAttackPoint(), givenUnit.getMaintainGold());
                                city.addPossibleUnit(rangeMilitaryUnit);
                                city.addProduct(new Product(rangeMilitaryUnit.getName(), rangeMilitaryUnit.getProductionPrice()));
                            }
                            // melee military unit
                            else {
                                meleeMilitaryUnit = new MeleeMilitaryUnit(givenUnit.getName(), null, givenUnit.getHP(), givenUnit.getGoldPrice(), givenUnit.getProductionPrice(), givenUnit.getLevel(), givenUnit.getMP(), givenUnit.getCombatStrength(), givenUnit.getRangeCombatStrength(), city.getOwner(), givenUnit.getAttackPoint(), givenUnit.getMaintainGold());
                                city.addPossibleUnit(meleeMilitaryUnit);
                                city.addProduct(new Product(meleeMilitaryUnit.getName(), meleeMilitaryUnit.getProductionPrice()));
                            }
                        }
                    }
                }
                //add given buildings to possible products of the city
                if (user.getCurrentTechnology().getGivenBuildings() != null) {
                    Building building;
                    for (Building givenBuilding : user.getCurrentTechnology().getGivenBuildings()) {
                        for (City city : user.getCities()) {
                            building = new Building(givenBuilding.getName(), givenBuilding.getMaintainCost(), givenBuilding.getCost(), givenBuilding.getFoodRate(), givenBuilding.getDefence(), givenBuilding.getXP(), givenBuilding.getScienceRate(), givenBuilding.getHappiness(), givenBuilding.getRequirement());
                            city.addPossibleBuildings(building);
                            city.addProduct(new Product(building.getName(), building.getCost()));
                        }
                    }
                }
                user.setCurrentTechnology(null);
            } else
                user.setResearchTurnLeft(user.getResearchTurnLeft() - 1);
        }
    }

    // check all workers
    public void userTurnWorker(User player) {
        if (player.getUnits() != null) {

            for (Unit unit : player.getUnits()) {
                // find worker
                if (unit.getName().equals("worker") && ((Worker) unit).getWorkingStatus()) {
                    Worker worker = (Worker) unit;
                    // if it is done
                    if (worker.getRemainingTurnsToComplete() <= 1) {
                        // delete jungle and jungle and forest and marsh
                        if (worker.getImprovement() != null) {
                            if (worker.getImprovement().getName().equals("Farm") || worker.getImprovement().getName().equals("Mine"))
                                if (worker.getTile().getFeature() != null)
                                    afterBuildingFarmOrMine(worker.getOwner(), worker.getTile());
                            // notification for improvement
                            UserPanel.improvementDoneNotification(player, worker.getImprovement());
                            worker.setWorkingStatus(false);
                            worker.setRemainingTurnsToComplete(0);
                            worker.getTile().setInProgress(false);
                            worker.getTile().setImprovement(worker.getImprovement());
                            worker.getImprovement().setTile(worker.getTile());
                            if (worker.getImprovement().getGivenResources() != null) {
                                for (Resource resource : worker.getImprovement().getGivenResources()) {
                                    if (worker.getTile().getResource() != null) {
                                        if (resource.getName().equals(worker.getTile().getResource().getName()))
                                            player.setAvailableResources(worker.getTile().getResource());
                                    }
                                }
                            }
                            worker.setImprovement(null);
                        }
                        else {
                            worker.setWorkingStatus(false);
                            worker.setRemainingTurnsToComplete(0);
                            worker.getTile().setInProgress(false);
                            worker.getTile().setRoad(true);
                            UserPanel.roadNotification(worker.getTile(), worker.getOwner());
                        }
                    } else {
                        worker.setRemainingTurnsToComplete(worker.getRemainingTurnsToComplete() - 1);
                    }
                }
            }
        }
    }

    // find the unit based on production name
    public void findProduction(City city, Product product) {
        Worker worker;
        Settler settler;
        Civilian scout;
        MeleeMilitaryUnit meleeMilitaryUnit;
        RangeMilitaryUnit rangeMilitaryUnit;
        for (int i = 0; i < city.getPossibleUnits().size(); i++) {
            if (city.getPossibleUnits().get(i).getName().equals(product.getName())) {
                Unit unit = city.getPossibleUnits().get(i);
                // worker
                if (unit.getName().equals("worker")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    worker = new Worker(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), false, city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(worker);
                    tile.setCivilianUnitExists(true);
                    worker.setTile(tile);
                    city.getOwner().addUnit(worker);
                    UserPanel.productDoneNotification(city.getOwner(), city, worker, this);
                }
                // settler
                else if (unit.getName().equals("settler")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    settler = new Settler("settler", tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), null, city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(settler);
                    tile.setCivilianUnitExists(true);
                    settler.setTile(tile);
                    city.getOwner().addUnit(settler);
                    UserPanel.productDoneNotification(city.getOwner(), city, settler, this);
                }
                else if (unit.getName().equals("scout")) {
                    Tile tile = findTileForCivilian(city.getTile());
                    scout = new Civilian("scout", tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setCivilianUnit(scout);
                    tile.setCivilianUnitExists(true);
                    scout.setTile(tile);
                    city.getOwner().addUnit(scout);
                    UserPanel.productDoneNotification(city.getOwner(), city, scout, this);
                }
                // ranged
                else if (unit.getRangeCombatStrength() > 0) {
                    Tile tile = findTileForMilitary(city.getTile());
                    rangeMilitaryUnit = new RangeMilitaryUnit(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setMilitaryUnit(rangeMilitaryUnit);
                    tile.setMilitaryUnitExists(true);
                    rangeMilitaryUnit.setTile(tile);
                    city.getOwner().addUnit(rangeMilitaryUnit);
                    UserPanel.productDoneNotification(city.getOwner(), city, rangeMilitaryUnit, this);
                }
                // melee
                else {
                    Tile tile = findTileForMilitary(city.getTile());
                    meleeMilitaryUnit = new MeleeMilitaryUnit(unit.getName(), tile, unit.getHP(), unit.getGoldPrice(), unit.getProductionPrice(), unit.getLevel(), unit.getMP(), unit.getCombatStrength(), unit.getRangeCombatStrength(), city.getOwner(), unit.getAttackPoint(), unit.getMaintainGold());
                    tile.setMilitaryUnit(meleeMilitaryUnit);
                    tile.setMilitaryUnitExists(true);
                    meleeMilitaryUnit.setTile(tile);
                    city.getOwner().addUnit(meleeMilitaryUnit);
                    UserPanel.productDoneNotification(city.getOwner(), city, meleeMilitaryUnit, this);
                }
                return;
            }
        }

        for (Building building : city.getPossibleBuildings()) {
            if (building.getName().equals(product.getName())) {
                Building building1 = new Building(building.getName(), building.getMaintainCost(), building.getCost(), building.getFoodRate(), building.getDefence(), building.getXP(), building.getScienceRate(), building.getHappiness(), building.getRequirement());
                city.addBuildings(building1);
                UserPanel.productDoneNotification(city.getOwner(), city, building);
                return;
            }
        }

    }

    public void increaseCitizens(User user){
        for (City city : user.getCities()) {
            if (city.getTurnNumber() >= 10){
                city.setTurnNumber(0);
                city.setCitizensNumber(city.getCitizensNumber() + 1);
                Citizen citizen = new Citizen(null);
                city.addCitizen(citizen);
                new UserPanel(this).citizensIncreased(user, city);
                if (city.getCitizensNumber() % 5 == 0){
                    user.setUnhappiness(user.getUnhappiness() + 1);
                }
            } else city.setTurnNumber(city.getTurnNumber() + 1);
        }
    }

    public void usersIncomeHandling(User user, Maps map) {
        user.setGoldPerTurn(0);
        user.setFoodPerTurn(0);
        user.setProductPerTurn(0);
        user.setSciencePerTurn(0);
        new ResourceController().userResource(user, map);
        if (user.getImprovements() != null && user.getImprovements().size() > 0) {
            for (Tile tile : user.getTerritory()) {
                if (tile.getImprovement() != null && !tile.isLooted()) {
                    user.setGoldPerTurn(user.getGoldPerTurn() + tile.getImprovement().getGoldRate());
                    user.setFoodPerTurn(user.getFoodPerTurn() + tile.getImprovement().getFoodRate());
                    user.setProductPerTurn(user.getProductPerTurn() + tile.getImprovement().getProductionRate());
                }
            }
        }
        if (user.getCities() != null){
            for (City city : user.getCities()) {
                user.setGoldPerTurn(user.getGoldPerTurn() + city.getGold());
                user.setFood(user.getFoodPerTurn() + city.getFood());
                user.setSciencePerTurn(city.getCitizensNumber() + 3);
            }
        }
        user.setGold(user.getGold() + user.getGoldPerTurn());
        user.setFood(user.getFood() + user.getFoodPerTurn());
        user.setScience(user.getScience() + user.getSciencePerTurn());
        if (user.getUnits() != null){
            for (Unit unit : user.getUnits()) {
                user.setGold(user.getGold() - unit.getMaintenance());
            }
        }
        for (Tile tile : user.getTerritory()) {
            if (tile.isRoad()){
                if(user.getTurns() % 3 == 0) user.setGold(user.getGold() - 1);
            }
        }
        if (user.getGold() < 0){
            user.setScience(user.getScience() + user.getGold());
            user.setGold(0);
        }
    }
*/
    public Tile findTileForMilitary(Tile origin) {
        if (origin.isMilitaryUnitExists()) {
            for (Tile neighbor : origin.getNeighbors()) {
                if (!neighbor.isMilitaryUnitExists() && neighbor.getTerrain().isPassable())
                    return neighbor;
            }
            for (Tile neighbor : origin.getNeighbors()) {
                for (Tile neighborNeighbor : neighbor.getNeighbors()) {
                    if (!neighborNeighbor.isMilitaryUnitExists() && neighbor.getTerrain().isPassable())
                        return neighborNeighbor;
                }
            }
        }
        return origin;
    }
    public Tile findTileForCivilian(Tile origin) {
        if (origin.isCivilianUnitExists()) {
            for (Tile neighbor : origin.getNeighbors()) {
                if (!neighbor.isCivilianUnitExists() && neighbor.getTerrain().isPassable())
                    return neighbor;
            }
            for (Tile neighbor : origin.getNeighbors()) {
                for (Tile neighborNeighbor : neighbor.getNeighbors()) {
                    if (!neighborNeighbor.isCivilianUnitExists() && neighbor.getTerrain().isPassable()){
                        return neighborNeighbor;}
                }
            }
        }
        return origin;
    }
    public void userHappiness(User user){
        for (City city : user.getCities()) {
            if (!city.isUnhappinessEffect())
                user.setUnhappiness(user.getUnhappiness() + 3);
        }
        for (Resource foundResource : user.getFoundResources()) {
            if (user.getAvailableResources().contains(foundResource))
                user.setHappiness(user.getHappiness() + foundResource.getHappiness());
        }
        for (City city : user.getAnnexedCities()) {
            if (!city.isUnhappinessEffect())
                user.setUnhappiness(user.getUnhappiness() + 4);
        }
    }


    public void citiesIncome(User user){
        for (City city : user.getCities()) {
            city.setProduction(0);
            city.setFood(0);
            city.setGold(0);
            for (Citizen citizen : city.getCitizens()) {
                if (citizen.getTile() != null){
                    if (citizen.getTile().getFeature() != null){
                        city.setGold(citizen.getTile().getFeature().getGoldRate());
                        city.setFood(citizen.getTile().getFeature().getFoodRate());
                        city.setProduction(citizen.getTile().getFeature().getProductionRate());
                    }
                    city.setGold(city.getGold() + citizen.getTile().getTerrain().getGoldRate());
                    city.setFood(city.getFood() + citizen.getTile().getTerrain().getFoodRate());
                    city.setProduction(city.getProduction() + citizen.getTile().getTerrain().getProductionRate());
                }
                city.setProduction(city.getProduction() + 1);
                city.setFood(city.getFood() - 1);
            }
        }
    }

    private void afterBuildingFarmOrMine(User user, Tile tile) {
        switch (tile.getFeature().getName()) {
            case "Jungle", "Forest", "Marsh" -> tile.setFeature(null);
        }
    }

    public void makeAllUnOrdered(User user) {
        if (user.getUnits() != null) {
            for (Unit unit : user.getUnits()) {
                if (!unit.isAlert() && !unit.isSleep() && !unit.isFortify())
                    unit.setOrdered(false);
                if (unit.isAlert()) {
                    for (Tile neighbor : unit.getTile().getNeighbors()) {
                        if (neighbor.isMilitaryUnitExists() && !neighbor.getMilitaryUnit().getOwner().equals(user)) {
                            unit.setAlert(false);
                            unit.setOrdered(false);
                        }
                    }
                }
                //check fortify units
                if (unit.isFortify()) {
                    if (unit.getHP() < unit.getTotalHealth())
                        unit.setHP(unit.getHP() + 10);
                    if (unit.getHP() > unit.getTotalHealth()) {
                        unit.setHP(unit.getTotalHealth());
                        unit.setFortify(false);
                    }
                }
            }
        }
    }
/*
    public void foundCity(User user) {
        if (user.getUnits() != null) {
            for (Unit unit : user.getUnits()) {
                for (Tile neighbor : unit.getTile().getNeighbors()) {
                    if (neighbor.getCity() != null &&
                            neighbor.getCity().getTile().equals(neighbor) &&
                            !neighbor.getOwner().equals(user) &&
                            !user.getFoundCities().contains(neighbor.getCity())) {
                        user.addFoundCities(neighbor.getCity());
                        UserPanel.foundCity(neighbor.getCity(), user);
                    }
                }
            }
        }
    }
    */
    /*
    public void moveTravelingUnits(User user, PlayGame playGame) {
        for (Unit unit : user.getUnits()) {
            if (unit.isMoving()) {
                if (unit.getTile().isMilitaryUnitExists() && unit.getTile().isSelectedOne()) {
                    playGame.moveUnit(unit.getTile(), unit.getDestination(), unit, user, true);
                    unit.setOrdered(true);
                    if (unit.getTile().equals(unit.getDestination())) {
                        unit.setMoving(false);
                        unit.setDestination(null);
                    }
                }
                else if (unit.getTile().isCivilianUnitExists() && unit.getTile().isSelectedTwo()) {
                    playGame.moveUnit(unit.getTile(), unit.getDestination(), unit, user, false);
                    unit.setOrdered(true);
                    if (unit.getTile().equals(unit.getDestination())) {
                        unit.setMoving(false);
                        unit.setDestination(null);
                    }
                }
            }
        }
    }
       */
    public void assignNeighbor(Maps map) {

        // assign all the neighbors to each tile
        for (int i = 0; i < map.getHeight(); i++)
            for (int j = 0; j < map.getWidth(); j++)
                MapController.getInstance().setNeighbor(map.getTileBoard()[i][j], map);
    }
    /*
    public void foundRuin(User user) {
        for (Unit unit : user.getUnits()) {
            if (unit.getTile().getRuin() != null) {
                if (!user.getFoundRuins().contains(unit.getTile().getRuin())) {
                    UserPanel.foundRuin(unit.getTile().getRuin(), user);
                    Ruin ruin = unit.getTile().getRuin();
                    if (ruin.getGivenTechnologies() != null)
                        addRuinEffectTech(ruin, user);
                    if (ruin.getGold() > 0)
                        addRuinEffectGold(ruin, user);
                    addRuinEffectPopulation(user);
                    if (ruin.isWorker())
                        addRuinEffectWorker(user);
                    if (ruin.isSettler())
                        addRuinEffectSettler(user);
                    if (ruin.getRemovedFogs() != null)
                        addRuinEffectFogOfTile(ruin, user);

                }
            }
        }
    }

     */
/*
    private void addRuinEffectTech(Ruin ruin, User user) {
        for (Technology givenTechnology : ruin.getGivenTechnologies()) {
            if (!user.getTechnologies().contains(givenTechnology)) {
                user.setResearchTurnLeft(1);
                user.setResearching(true);
                user.setCurrentTechnology(givenTechnology);
                userTurnResearch(user);
            }
        }
    }

    private void addRuinEffectGold(Ruin ruin, User user) {
        user.setGold(ruin.getGold());
    }

    private void addRuinEffectPopulation(User user) {
        //todo add one citizen
    }

    private void addRuinEffectWorker(User user) {
        user.getCapital().setProductStatus(true);
        user.getCapital().setCurrentProduction(user.getCapital().getProducts().get(0));
        user.getCapital().setProductTurnLeft(1);
        cityTurnProducts(user);
    }

    private void addRuinEffectSettler(User user) {
        user.getCapital().setProductStatus(true);
        user.getCapital().setCurrentProduction(user.getCapital().getProducts().get(1));
        user.getCapital().setProductTurnLeft(1);
        cityTurnProducts(user);
    }

    private void addRuinEffectFogOfTile(Ruin ruin, User user) {
        for (Tile removedFog : ruin.getRemovedFogs()) {
            if (!user.getVisited().contains(removedFog))
                user.addVisited(removedFog);
        }
    }

    public void addTech(Technology technology, User user) {
        user.setResearchTurnLeft(1);
        user.setResearching(true);
        user.setCurrentTechnology(technology);
        userTurnResearch(user);
    }
*/
    public Response nextTurn(Request request) {

        Response response = new Response();

        Boolean cheat = (Boolean) request.getParameters().get("cheat");
        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        if (cheat.equals(false)) {
            //next turn raw
            boolean did = true;
            if (user.getUnits() != null) {
                for (Unit unit : user.getUnits()) {
                    if (!unit.isOrdered() && !unit.isAlert() && !unit.isSleep()) {
                        did = false;
                        break;
                    }
                }
            }
            if (did) {
                //next turn
                acceptNextTurn(response, user);
            }
            else {
                //next turn is not possible
                response.setStatusCode("401");
                response.setMessage("you didn't play all your turns");
                HashMap<String, Object> parameters = new HashMap<>();
                parameters.put("next turn", Boolean.FALSE);
                response.setParameters(parameters);
            }
        }
        else {
            //next turn --force
            acceptNextTurn(response, user);
        }
        return response;
    }

    private void acceptNextTurn(Response response, User user) {
        response.setStatusCode("200");
        response.setMessage("next turn");
        HashMap<String, Object> parameters = new HashMap<>();
        parameters.put("next turn", Boolean.TRUE);
        response.setParameters(parameters);
        user.setTurns(1);
    }

    public Response increaseTurnRequest(Request request) {
        Response response = new Response();

        String username = (String)request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer)request.getParameters().get("amount");

        if (amount > 0) {
            increaseTurn(amount, user);
            makeAllUnOrdered(user);
            UnitController.getInstance().repairMovementPoint(user);
            response.setMessage("turn increased successfully!");
        } else
            response.setMessage("invalid number");

        return response;
    }

    public Response increaseGoldRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");
        if (amount > 0) {
            increaseGold(amount, user);
            response.setMessage("gold increased successfully!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseFoodRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        int amount = (Integer) request.getParameters().get("amount");
        if (amount > 0) {
            gameController.increaseFood(amount, user);
            response.setMessage("food increased successfully!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseFaithRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);

        int amount = (Integer) request.getParameters().get("amount");
        if (amount > 0) {
            increaseFaith(amount, user);
            response.setMessage("faith increased successfully!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseScienceRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            increaseScience(amount, user);
            response.setMessage("science increased successfully!");

        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseCapitalCitizensRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            if (user.getCapital() != null) {
                increaseCapitalCitizens(amount, user);
                response.setMessage("capitalCitizens increased successfully!");
            }
            else
                response.setMessage("user doesn't have capital right now!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseCapitalDefenceRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            if (user.getCapital() != null) {
                increaseCapitalDefence(amount, user);
                response.setMessage("capitalDefence increased successfully!");
            }
            else
                response.setMessage("user doesn't have capital right now!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseCultureRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            increaseCulture(amount, user);
            response.setMessage("culture increased successfully!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response increaseHappinessRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            increaseHappiness(amount, user);
            response.setMessage("happiness increased successfully!");
        } else
            response.setMessage("invalid command");

        return response;
    }

    public Response decreaseResearchTurnRequest(Request request) {
        Response response = new Response();

        String username = (String) request.getParameters().get("username");
        User user = UsersController.getInstance().getUserByUsername(username);
        int amount = (Integer) request.getParameters().get("amount");

        if (amount > 0) {
            if (user.getCurrentTechnology() != null) {
                decreaseResearchTurnLeft(amount, user);
                response.setMessage("researches increased successfully!");
            }
            else
                response.setMessage("user don't research on anything right now!");
        } else
            response.setMessage("invalid number");

        return response;
    }

    public Response selectTileRequest(Request request) {
        Response response = new Response();

        int xOrigin = (Integer)request.getParameters().get("x");
        int yOrigin = (Integer)request.getParameters().get("y");
        if (xOrigin >= 0 && yOrigin >= 0 && xOrigin <= width && yOrigin <= height) {
            response.setStatusCode("200");
            response.setMessage("valid coordinates!");
        }
        else {
            response.setStatusCode("404");
            response.setMessage("invalid coordinates!");
        }
        return response;
    }

    public Response setPlayers(Request request, Maps map) {
        Response response = new Response();
        ArrayList<User> users = UsersController.getInstance().getUsers();
        request.getParameters().forEach((username, playerUsername) -> {
            for (User user : users) {
                if (user.getUsername().equals(playerUsername)) players.add(user);
            }
        });
        ArrayList<User> truePlayers = new ArrayList<>(players);
        players.clear();
        for (int i = truePlayers.size() - 1; i >= 0; i--) {
            players.add(truePlayers.get(i));
        }
        for (User player : GameController.getInstance().getPlayers()) {
            System.out.println(player.getUsername());
        }
        MapController.getInstance().firstSetOfSettlers(GameController.getInstance().getPlayers(), map);
        response.setMessage("start the game");
        return response;
    }

    public Response searchFriend(Request request) {
        Response response = new Response();
        String username = (String) request.getParameters().get("username");
        for (User user : UsersController.getInstance().getUsers()) {
            if (user.getUsername().equals(username)) {
                response.setMessage(username);
                return response;
            }
        }
        response.setMessage("there is no player with this username!");
        return response;
    }

}
