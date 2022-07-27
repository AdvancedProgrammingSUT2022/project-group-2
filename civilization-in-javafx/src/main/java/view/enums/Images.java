package view.enums;

import javafx.scene.image.Image;

public class Images {

    private static Images images;

    public static Images getInstance() {
        if (images == null) images = new Images();
        return images;
    }
    public Image normalMenuButton;
    public Image selectedMenuButton;
    public Image submitMenuButton;
    public Image mainMenuButtonBackGround;
    public Image desertCell;
    public Image hillCell;
    public Image plainCell;
    public Image snowCell;
    public Image tundraCell;
    public Image grasslandCell;
    public Image jungleCell;
    public Image oceanCell;
    public Image mountainCell;
    public Image mountainCell2;
    public Image forestCell;
    public Image marshCell;
    public Image iceCell;
    public Image floodPlainCell;
    public Image oasisCell;
    public Image banana;
    public Image coal;
    public Image color;
    public Image cotton;
    public Image cow;
    public Image deer;
    public Image fumigation;
    public Image fur;
    public Image gemStone;
    public Image goldResource;
    public Image horse;
    public Image iron;
    public Image ivory;
    public Image marble;
    public Image sheep;
    public Image silk;
    public Image silver;
    public Image sugar;
    public Image wheat;
    public Image gold;
    public Image science;
    public Image food;
    public Image production;
    public Image happiness;
    public Image unhappiness;
    public Image chariotArcher;
    public Image scout;
    public Image settler;
    public Image spearman;
    public Image warrior;
    public Image worker;
    public Image catapult;
    public Image horseman;
    public Image swordMan;
    public Image crossbowman;
    public Image knight;
    public Image longSwordsman;
    public Image pikeMan;
    public Image trebuchet;
    public Image canon;
    public Image cavalry;
    public Image lancer;
    public Image musketMan;
    public Image rifleMan;
    public Image antiTankGun;
    public Image artillery;
    public Image infantry;
    public Image panzer;
    public Image tank;
    public Image chariotArcherIcon;
    public Image scoutIcon;
    public Image settlerIcon;
    public Image spearmanIcon;
    public Image warriorIcon;
    public Image workerIcon;
    public Image catapultIcon;
    public Image horsemanIcon;
    public Image swordManIcon;
    public Image crossbowmanIcon;
    public Image knightIcon;
    public Image longSwordsmanIcon;
    public Image pikeManIcon;
    public Image trebuchetIcon;
    public Image canonIcon;
    public Image cavalryIcon;
    public Image lancerIcon;
    public Image musketManIcon;
    public Image rifleManIcon;
    public Image antiTankGunIcon;
    public Image artilleryIcon;
    public Image infantryIcon;
    public Image panzerIcon;
    public Image tankIcon;
    public Image city;
    public Image avatar1;
    public Image avatar2;
    public Image avatar3;
    public Image avatar4;
    public Image avatar5;
    public Image avatar6;
    public Image avatar7;
    public Image avatar8;
    public Image avatar9;
    public Image avatar10;
    public Image alertIcon;
    public Image autoPlayingIcon;
    public Image deleteUnitIcon;
    public Image doNothingIcon;
    public Image fortifyIcon;
    public Image meleeAttackIcon;
    public Image movingIcon;
    public Image otherActionIcon;
    public Image rangeAttackIcon;
    public Image wakeIcon;
    public Image foundCityIcon;
    public Image unitInfoBackground;
    public Image workerInfoBackground;
    public Image unitMoreActionInfoBackground;
    public Image workerMoreActionInfoBackground;
    public Image goldenRing;
    public Image X_button;
    public Image acoustics;
    public Image agriculture;
    public Image animalHusbandry;
    public Image archaeology;
    public Image archery;
    public Image banking;
    public Image biology;
    public Image bronzeWorking;
    public Image calendar;
    public Image chemistry;
    public Image chivalry;
    public Image civilService;
    public Image combustion;
    public Image construction;
    public Image currency;
    public Image dynamite;
    public Image economics;
    public Image education;
    public Image electricity;
    public Image engineering;
    public Image fertilizer;
    public Image gunpowder;
    public Image horsebackRiding;
    public Image ironWorking;
    public Image machinery;
    public Image masonry;
    public Image mathematics;
    public Image metalCasting;
    public Image metallurgy;
    public Image militaryScience;
    public Image mining;
    public Image philosophy;
    public Image physics;
    public Image pottery;
    public Image printingPress;
    public Image radio;
    public Image railroad;
    public Image replaceableParts;
    public Image rifling;
    public Image scientificTheory;
    public Image steel;
    public Image steamPower;
    public Image telegraph;
    public Image theWheel;
    public Image theology;
    public Image trapping;
    public Image writing;
    public Image completeTechBackground;
    public Image availableTechBackground;
    public Image unCompleteTechBackground;
    public Image inProgressTechBackground;
    public Image Armory;
    public Image Arsenal;
    public Image Bank;
    public Image Barracks;
    public Image BroadcastTower;
    public Image BurialTomb;
    public Image Castle;
    public Image Circus;
    public Image Colosseum;
    public Image Courthouse;
    public Image Factory;
    public Image Forge;
    public Image Garden;
    public Image Granary;
    public Image Hospital;
    public Image Library;
    public Image Market;
    public Image MilitaryAcademy;
    public Image MilitaryBase;
    public Image Mint;
    public Image Monastery;
    public Image Monument;
    public Image Museum;
    public Image OperaHouse;
    public Image PublicSchool;
    public Image satrapCourt;
    public Image Stable;
    public Image StockExchange;
    public Image Temple;
    public Image Theatre;
    public Image University;
    public Image Walls;
    public Image Watermill;
    public Image Windmill;
    public Image WorkShop;
    public Image Camp;
    public Image Farm;
    public Image LumberMill;
    public Image ManuFactory;
    public Image Mine;
    public Image Pasture;
    public Image Plantation;
    public Image Quarry;
    public Image Railroads;
    public Image Roads;
    public Image TradingPost;
    public Image cantNextTurn;
    public Image nextTurn;
    public Image setting;
    public Image ruin;
    public Image peace;
    public Image noPeace;
    public Image nothingInPeace;
    public Image resourceIcon;
    public Image chatBox;

    public Images(){
        normalMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Down.png")));
        selectedMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Selected.png")));
        submitMenuButton = new Image(String.valueOf(getClass().getResource("/Media/buttons/Button_Normal.png")));
        mainMenuButtonBackGround = new Image(String.valueOf(getClass().getResource("/Media/buttons/Menu-buttons-pic3.png")));
        desertCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/DesertCell.png")));
        hillCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/HillCell.png")));
        plainCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/PlainCell.png")));
        snowCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/snowCell.png")));
        tundraCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/TundraCell.png")));
        grasslandCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/GrasslandCell.png")));
        jungleCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/JungleCell.png")));
        oceanCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/OceanCell.png")));
        mountainCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/MountainCell.png")));
        mountainCell2 = new Image(String.valueOf(getClass().getResource("/Media/tiles/MountainCell2.png")));
        forestCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/forestCell.png")));
        iceCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/iceCell.png")));
        marshCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/PlainCell2.png")));
        floodPlainCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/floodPlainCell.png")));
        oasisCell = new Image(String.valueOf(getClass().getResource("/Media/tiles/oasisCell.png")));
        banana = new Image(String.valueOf(getClass().getResource("/Media/resource/banana.png")));
        coal = new Image(String.valueOf(getClass().getResource("/Media/resource/coal.png")));
        color = new Image(String.valueOf(getClass().getResource("/Media/resource/color.png")));
        cotton = new Image(String.valueOf(getClass().getResource("/Media/resource/cotton.png")));
        cow = new Image(String.valueOf(getClass().getResource("/Media/resource/cow.png")));
        deer = new Image(String.valueOf(getClass().getResource("/Media/resource/deer.png")));
        fumigation = new Image(String.valueOf(getClass().getResource("/Media/resource/fumigation.png")));
        fur = new Image(String.valueOf(getClass().getResource("/Media/resource/fur.png")));
        gemStone = new Image(String.valueOf(getClass().getResource("/Media/resource/gemStone.png")));
        goldResource = new Image(String.valueOf(getClass().getResource("/Media/resource/gold.png")));
        horse = new Image(String.valueOf(getClass().getResource("/Media/resource/horse.png")));
        iron = new Image(String.valueOf(getClass().getResource("/Media/resource/iron.png")));
        ivory = new Image(String.valueOf(getClass().getResource("/Media/resource/ivory.png")));
        marble = new Image(String.valueOf(getClass().getResource("/Media/resource/marble.png")));
        sheep = new Image(String.valueOf(getClass().getResource("/Media/resource/sheep.png")));
        silk = new Image(String.valueOf(getClass().getResource("/Media/resource/silk.png")));
        silver = new Image(String.valueOf(getClass().getResource("/Media/resource/silver.png")));
        sugar = new Image(String.valueOf(getClass().getResource("/Media/resource/sugar.png")));
        wheat = new Image(String.valueOf(getClass().getResource("/Media/resource/wheat.png")));
        gold = new Image(String.valueOf(getClass().getResource("/Media/icons/gold.png")));
        science = new Image(String.valueOf(getClass().getResource("/Media/icons/science.png")));
        food = new Image(String.valueOf(getClass().getResource("/Media/icons/food.png")));
        production = new Image(String.valueOf(getClass().getResource("/Media/icons/production.png")));
        happiness = new Image(String.valueOf(getClass().getResource("/Media/icons/happiness.png")));
        unhappiness = new Image(String.valueOf(getClass().getResource("/Media/icons/unhappiness.png")));
        chariotArcher = new Image(String.valueOf(getClass().getResource("/Media/Units/Chariot Archer.png")));
        scout = new Image(String.valueOf(getClass().getResource("/Media/Units/Scout.png")));
        settler = new Image(String.valueOf(getClass().getResource("/Media/Units/Settler.png")));
        spearman = new Image(String.valueOf(getClass().getResource("/Media/Units/Spearman.png")));
        warrior = new Image(String.valueOf(getClass().getResource("/Media/Units/Warrior.png")));
        worker = new Image(String.valueOf(getClass().getResource("/Media/Units/Worker.png")));
        catapult = new Image(String.valueOf(getClass().getResource("/Media/Units/Catapult.png")));
        horseman = new Image(String.valueOf(getClass().getResource("/Media/Units/Horseman.png")));
        swordMan = new Image(String.valueOf(getClass().getResource("/Media/Units/Swordsman.png")));
        crossbowman = new Image(String.valueOf(getClass().getResource("/Media/Units/Crossbowman.png")));
        knight = new Image(String.valueOf(getClass().getResource("/Media/Units/Knight.png")));
        longSwordsman = new Image(String.valueOf(getClass().getResource("/Media/Units/Longswordsman.png")));
        pikeMan = new Image(String.valueOf(getClass().getResource("/Media/Units/Pikeman.png")));
        trebuchet = new Image(String.valueOf(getClass().getResource("/Media/Units/Trebuchet.png")));
        canon = new Image(String.valueOf(getClass().getResource("/Media/Units/Cannon.png")));
        cavalry = new Image(String.valueOf(getClass().getResource("/Media/Units/Cavalry.png")));
        lancer = new Image(String.valueOf(getClass().getResource("/Media/Units/Lancer.png")));
        musketMan = new Image(String.valueOf(getClass().getResource("/Media/Units/Musketman.png")));
        rifleMan = new Image(String.valueOf(getClass().getResource("/Media/Units/Rifleman.png")));
        antiTankGun = new Image(String.valueOf(getClass().getResource("/Media/Units/Anti-Tank Gun.png")));
        artillery = new Image(String.valueOf(getClass().getResource("/Media/Units/Artillery.png")));
        infantry = new Image(String.valueOf(getClass().getResource("/Media/Units/Infantry.png")));
        panzer = new Image(String.valueOf(getClass().getResource("/Media/Units/Panzer.png")));
        tank = new Image(String.valueOf(getClass().getResource("/Media/Units/Tank.png")));
        chariotArcherIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/ChariotArcherIcon.png")));
        scoutIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/ScoutIcon.png")));
        settlerIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/SettlerIcon.png")));
        spearmanIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/SpearManIcon.png")));
        warriorIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/WarriorIcon.png")));
        workerIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/WorkerIcon.png")));
        catapultIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/CatapultIcon.png")));
        horsemanIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/HorseManIcon.png")));
        swordManIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/SwordsManIcon.png")));
        crossbowmanIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/CrossbowManIcon.png")));
        knightIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/KnightIcon.png")));
        longSwordsmanIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/LongSwordsManIcon.png")));
        pikeManIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/PikeManIcon.png")));
        trebuchetIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/TrebuchetIcon.png")));
        canonIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/CannonIcon.png")));
        cavalryIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/CavalryIcon.png")));
        lancerIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/LancerIcon.png")));
        musketManIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/MusketManIcon.png")));
        rifleManIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/RifleManIcon.png")));
        antiTankGunIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/AntiTankGunIcon.png")));
        artilleryIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/ArtilleryIcon.png")));
        infantryIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/InfantryIcon.png")));
        panzerIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/PanzerIcon.png")));
        tankIcon = new Image(String.valueOf(getClass().getResource("/Media/Units/TankIcon.png")));
        city = new Image(String.valueOf(getClass().getResource("/Media/city/City.png")));
        avatar1 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar1.png")));
        avatar2 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar2.png")));
        avatar3 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar3.png")));
        avatar4 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar4.png")));
        avatar5 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar5.png")));
        avatar6 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar6.png")));
        avatar7 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar7.png")));
        avatar8 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar8.png")));
        avatar9 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar9.png")));
        avatar10 = new Image(String.valueOf(getClass().getResource("/Media/avatars/avatar10.png")));
        alertIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/AlertIcon.png")));
        wakeIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/WakeIcon.png")));
        autoPlayingIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/AutoPlayingIcon.png")));
        deleteUnitIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/DeleteUnit.png")));
        meleeAttackIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/MeleeAttackIcon.png")));
        rangeAttackIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/RangeAttackIcon.png")));
        movingIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/MovingIcon.png")));
        fortifyIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/FortifyIcon.png")));
        doNothingIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/DoNotingIcon.png")));
        otherActionIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/OtherActionIcon.png")));
        foundCityIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/FoundCityIcon.PNG")));
        unitInfoBackground = new Image(String.valueOf(getClass().getResource("/Media/buttons/UnitInfoBackground.png")));
        workerInfoBackground = new Image(String.valueOf(getClass().getResource("/Media/buttons/WorkerInfoBackground.png")));
        workerMoreActionInfoBackground = new Image(String.valueOf(getClass().getResource("/Media/buttons/WorkerMoreActionBackground.png")));
        unitMoreActionInfoBackground = new Image(String.valueOf(getClass().getResource("/Media/buttons/UnitMoreActionBackground.png")));
        goldenRing = new Image(String.valueOf(getClass().getResource("/Media/background and videos/goldenRing.png")));
        X_button = new Image(String.valueOf(getClass().getResource("/Media/icons/X_button2.png")));
        acoustics = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Acoustics.png")));
        agriculture = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Agriculture.png")));
        animalHusbandry = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Animal_Husbandry.png")));
        archaeology = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Archaeology.png")));
        archery = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Archery.png")));
        banking = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Banking.png")));
        biology = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Biology.png")));
        bronzeWorking = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Bronze_Working.png")));
        calendar = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Calendar.png")));
        chemistry = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Chemistry.png")));
        chivalry = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Chivalry.png")));
        civilService = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Civil_Service.png")));
        combustion = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Combustion.png")));
        construction = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Construction.png")));
        currency = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Currency.png")));
        dynamite = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Dynamite.png")));
        economics = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Economics.png")));
        education = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Education.png")));
        electricity = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Electricity.png")));
        engineering = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Engineering.png")));
        fertilizer = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Fertilizer.png")));
        gunpowder = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Gunpowder.png")));
        horsebackRiding = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Horseback_Riding.png")));
        ironWorking = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Iron_Working.png")));
        machinery = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Machinery.png")));
        masonry = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Masonry.png")));
        mathematics = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Mathematics.png")));
        metalCasting = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Metal_Casting.png")));
        metallurgy = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Metallurgy.png")));
        militaryScience = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Military_Science.png")));
        mining = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Mining.png")));
        philosophy = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Philosophy.png")));
        physics = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Physics.png")));
        pottery = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Pottery.png")));
        printingPress = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Printing_Press.png")));
        radio = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Radio.png")));
        railroad = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Railroad.png")));
        replaceableParts = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Replaceable_Parts.png")));
        rifling = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Rifling.png")));
        scientificTheory = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Scientific_Theory.png")));
        steel = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Steel.png")));
        steamPower = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Steam_Power.png")));
        telegraph = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Telegraph.png")));
        theWheel = new Image(String.valueOf(getClass().getResource("/Media/Technologies/The_Wheel.png")));
        theology = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Theology.png")));
        trapping = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Trapping.png")));
        writing = new Image(String.valueOf(getClass().getResource("/Media/Technologies/Writing.png")));
        completeTechBackground = new Image(String.valueOf(getClass().getResource("/Media/background and videos/goldTechnoBackground.PNG")));
        availableTechBackground = new Image(String.valueOf(getClass().getResource("/Media/background and videos/greenTechnoBackground.PNG")));
        unCompleteTechBackground  = new Image(String.valueOf(getClass().getResource("/Media/background and videos/blackTechnoBackground.PNG")));
        inProgressTechBackground = new Image(String.valueOf(getClass().getResource("/Media/background and videos/blueTechnoBackground.PNG")));
        Armory = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Armory.png")));
        Arsenal = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Arsenal.png")));
        Bank = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Bank.png")));
        Barracks = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Barracks.png")));
        BroadcastTower = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Broadcasttower.png")));
        BurialTomb = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Burial_Tomb.png")));
        Castle = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Castle.png")));
        Circus = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Circus.png")));
        Colosseum = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Colosseum.png")));
        Courthouse = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Courthouse.png")));
        Factory = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Factory.png")));
        Forge = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Forge.png")));
        Garden = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Garden.png")));
        Granary = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Granary.png")));
        Hospital = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Hospital.png")));
        Library = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Library.png")));
        Market = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Market.png")));
        MilitaryAcademy = new Image(String.valueOf(getClass().getResource("/Media/Buildings/MilitaryAcademy.png")));
        MilitaryBase = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Militarybase.png")));
        Mint = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Mint.png")));
        Monastery = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Monastery.png")));
        Monument = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Monument.png")));
        Museum = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Museum.png")));
        OperaHouse = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Operahouse.png")));
        PublicSchool = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Publicschool.png")));
        satrapCourt = new Image(String.valueOf(getClass().getResource("/Media/Buildings/SatrapCourt.png")));
        Stable = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Stable.png")));
        StockExchange = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Stockexchange.png")));
        Temple = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Temple.png")));
        Theatre = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Theatre.png")));
        University = new Image(String.valueOf(getClass().getResource("/Media/Buildings/University.png")));
        Walls = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Walls.png")));
        Watermill = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Watermill.png")));
        Windmill = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Windmill.png")));
        WorkShop = new Image(String.valueOf(getClass().getResource("/Media/Buildings/Workshop.png")));
        Camp = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Camp.png")));
        Farm = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Farm.png")));
        LumberMill = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Lumber_Mill.png")));
        ManuFactory = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Manufactory.png")));
        Mine = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Mine.png")));
        Pasture = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Pasture.png")));
        Plantation = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Plantation.png")));
        Quarry = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Quarry.png")));
        Railroads = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Railroads.png")));
        Roads = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Roads.png")));
        TradingPost = new Image(String.valueOf(getClass().getResource("/Media/Improvements/Trading_Post.png")));
        cantNextTurn = new Image(String.valueOf(getClass().getResource("/Media/icons/X_button.png")));
        nextTurn = new Image(String.valueOf(getClass().getResource("/Media/icons/V_button.png")));
        setting = new Image(String.valueOf(getClass().getResource("/Media/icons/setting.png")));
        ruin = new Image(String.valueOf(getClass().getResource("/Media/resource/ruinIcon.png")));
        peace = new Image(String.valueOf(getClass().getResource("/Media/icons/Peace.png")));
        noPeace = new Image(String.valueOf(getClass().getResource("/Media/icons/No peace.png")));
        nothingInPeace = new Image(String.valueOf(getClass().getResource("/Media/icons/nothing in peace.png")));
        resourceIcon = new Image(String.valueOf(getClass().getResource("/Media/icons/resourceIcon.png")));
        chatBox = new Image(String.valueOf(getClass().getResource("/Media/icons/chatBox.png")));
    }
}
