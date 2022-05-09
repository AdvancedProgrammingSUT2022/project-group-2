package controller;

import model.*;

import java.util.ArrayList;
import java.util.HashMap;

public class SettlerController extends UnitController{
    public void createNewCity(Unit unit, User user, Tile tile, String nameOfCity) {
        // TODO : tiles near city
        ArrayList<Tile> ownerShipTiles = new ArrayList<>();
        ownerShipTiles.add(tile);
        HashMap<Citizen, Tile> citizensLocations = new HashMap<>();
        City city = new City(nameOfCity, tile, user, ownerShipTiles, 100, 100, null, null,
                50, 0, 1, 1, 1, 1, 1, 1, 1,
                citizensLocations, null, null, false, null, 20);
        citizensLocations.put(new Citizen(), tile);
        tile.setCity(city);
        tile.setOwner(user);
        removeUnit(unit, user);
        addBasicProducts(tile.getCity());
        addBasicUnits(tile.getCity());
    }

    private void addBasicProducts(City city) {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("worker", 5));
        products.add(new Product("settler", 5));
        products.add(new Product("warrior", 5));
        city.setProducts(products);
    }

    // set basic units for production
    private void addBasicUnits(City city) {
        ArrayList<Unit> units = new ArrayList<>();
        units.add(new Worker("worker", city.getTile(), 100, 5, 1, 2, 0, 0, false, city.getOwner(), 0));
        units.add(new Settler("settler", city.getTile(), 100, 5, 1, 3, 0, 0, null, city.getOwner(), 0));
        units.add(new MeleeMilitaryUnit("warrior", city.getTile(), 100, 5, 1, 2, 20, 0, city.getOwner()));
        city.setPossibleUnits(units);
    }
}
