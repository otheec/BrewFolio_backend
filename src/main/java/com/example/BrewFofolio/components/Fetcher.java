package com.example.BrewFofolio.components;

import com.example.BrewFofolio.model.dummy.*;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class Fetcher{

    //TODO is in indeed to hold arraays of types, statuses and beers when services always check unique by name? more like nope
    //for example, brewery wich first uploads beer to database, owns the beer
    //TODO only brewery can have the beers, not the pubs (cosider it based on practical situations)
    //TODO is there need to store places as tables, dont sort them just using queries?
    //TODO fetching year range (for example 2005-2007) as 2 years in years (-> chaneg brewery dummy and model class etc)
    private List<BreweryDummy> breweries;
    private List<TypeDummy> types;
    private List<StatusDummy> statuses;
    private List<BeerDummy> beers;

    public Fetcher() {
        this.breweries = new ArrayList<>();
        this.types = new ArrayList<>();
        this.statuses = new ArrayList<>();
        this.beers = new ArrayList<>();
    }

    public void getBreweryDummiesFromExcel() throws Exception {
        try {
            String filePath = "src/main/resources/data/DTB.xlsx";
            FileInputStream fileInputStream = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fileInputStream);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            boolean isFirstRow = true;

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();

                if(isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                Cell type = currentRow.getCell(1);
                Cell shortName = currentRow.getCell(2);
                Cell longName = currentRow.getCell(3);
                Cell status = currentRow.getCell(7);
                Cell years = currentRow.getCell(8);
                Cell webpage = currentRow.getCell(9);
                Cell facebook = currentRow.getCell(10);
                Cell beers = currentRow.getCell(13);
                Cell visited = currentRow.getCell(18);

                BreweryDummy newBrewery = new BreweryDummy();
                NameDummy newName = new NameDummy();

                if (type != null && type.getCellType() == CellType.STRING) {
                    newBrewery.setType(addTypeDummy(type.getStringCellValue()));
                }

                if(shortName != null && shortName.getCellType() == CellType.STRING) {
                    newName.setShortName(shortName.getStringCellValue());
                }

                if(longName != null && longName.getCellType() == CellType.STRING) {
                    newName.setLongName(longName.getStringCellValue());
                }

                if (status != null && status.getCellType() == CellType.STRING) {
                    newBrewery.setStatus(addStatusDummy(status.getStringCellValue()));
                }

                if(years != null) {
                    CellType yearsCellType = years.getCellType();
                    switch (yearsCellType) {
                        case NUMERIC -> newBrewery.setYears(String.valueOf((int)years.getNumericCellValue()));
                        case BLANK -> newBrewery.setYears(null);
                        case STRING -> newBrewery.setYears(years.getStringCellValue());
                    }
                }

                if(webpage != null) {
                    CellType webpageCellType = webpage.getCellType();
                    switch (webpageCellType) {
                        case FORMULA -> newBrewery.setWebpage(webpage.getStringCellValue());
                        case STRING -> newBrewery.setWebpage(webpage.getStringCellValue());
                    }
                }

                if(facebook != null) {
                    CellType facebookCellType = facebook.getCellType();
                    switch (facebookCellType) {
                        case FORMULA -> newBrewery.setFacebook(facebook.getStringCellValue());
                        case STRING -> newBrewery.setFacebook(facebook.getStringCellValue());
                    }
                }

                if(beers != null && beers.getCellType() == CellType.STRING) {
                    String[] splitted = beers.getStringCellValue().split(", ");
                    for (String beer: splitted) {
                        newBrewery.addBeer(addBeerDummy(beer));
                    }
                }

                if(visited != null && visited.getCellType() == CellType.STRING) {
                    if (visited.getStringCellValue().equals("YES")) {
                        newBrewery.setVisited(true);
                    } else if (visited.getStringCellValue().equals("NO")) {
                        newBrewery.setVisited(false);
                    }
                }

                newBrewery.setName(newName);
                if (newName.getLongName() != null && newName.getShortName() != null) {
                    breweries.add(newBrewery);
                }
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public TypeDummy addTypeDummy(String type) {
        for (TypeDummy typeDummy: types) {
            if (typeDummy.getType().equals(type)) return typeDummy;
        }
        TypeDummy ret = new TypeDummy(type);
        types.add(ret);
        return ret;
    }

    public StatusDummy addStatusDummy(String status) {
        for (StatusDummy statusDummy: statuses) {
            if (statusDummy.getStatus().equals(status)) return statusDummy;
        }
        StatusDummy ret = new StatusDummy(status);
        statuses.add(ret);
        return ret;
    }

    public BeerDummy addBeerDummy(String beer) {
        for (BeerDummy beerDummy: beers) {
            if (beerDummy.getName().equals(beer)) return beerDummy;
        }
        BeerDummy ret = new BeerDummy(beer);
        beers.add(ret);
        return ret;
    }

    public List<BreweryDummy> getBreweries() {
        return breweries;
    }
}

