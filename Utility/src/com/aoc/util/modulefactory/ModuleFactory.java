package com.aoc.util.modulefactory;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author maczaka.
 */
public class ModuleFactory {

    private static final Map<Integer, String> DAYNAME_MAP = new HashMap<>();
    private static final String BASE_PACKAGE = "/src/com/aoc";
    private static final String DAYS_PACKAGE = BASE_PACKAGE + "/days";

    static {
        DAYNAME_MAP.put(1, "One");
        DAYNAME_MAP.put(2, "Two");
        DAYNAME_MAP.put(3, "Three");
        DAYNAME_MAP.put(4, "Four");
        DAYNAME_MAP.put(5, "Five");
        DAYNAME_MAP.put(6, "Six");
        DAYNAME_MAP.put(7, "Seven");
        DAYNAME_MAP.put(8, "Eight");
        DAYNAME_MAP.put(9, "Nine");
        DAYNAME_MAP.put(10, "Ten");
        DAYNAME_MAP.put(11, "Eleven");
        DAYNAME_MAP.put(12, "Twelve");
        DAYNAME_MAP.put(13, "Thirteen");
        DAYNAME_MAP.put(14, "Fourteen");
        DAYNAME_MAP.put(15, "Fifteen");
        DAYNAME_MAP.put(16, "Sixteen");
        DAYNAME_MAP.put(17, "Seventeen");
        DAYNAME_MAP.put(18, "Eighteen");
        DAYNAME_MAP.put(19, "Nineteen");
        DAYNAME_MAP.put(20, "Twenty");
        DAYNAME_MAP.put(21, "TwentyOne");
        DAYNAME_MAP.put(22, "TwentyTwo");
        DAYNAME_MAP.put(23, "TwentyThree");
        DAYNAME_MAP.put(24, "TwentyFour");
        DAYNAME_MAP.put(25, "TwentyFive");
    }

    public static void createModuleForYear(final int year) throws ModuleException {
        final File module = new File("Year" + year);
        if (!module.exists()) {
            throw new ModuleException("Module is not yet created!");
        }
        final String fullPath = "Year" + year + DAYS_PACKAGE + year;
        createNewDirectory(String.format("Year%s/src/com/", year));
        createNewDirectory(String.format("Year%s/src/com/aoc", year));
        createNewDirectory(fullPath);
        for (int i = 1; i < 26; i++) {
            createDayPackage(fullPath, i, year);
        }
        createNewFileAndWriteToIt("Year" + year + BASE_PACKAGE + "/Year" + year + ".java",
                String.format(FileTemplate.YEAR_BASE_TEMPLATE, getPackageImports(year), year, year, year)
        );
    }

    private static String getPackageImports(final int year) {
        final StringBuilder builder = new StringBuilder("\n");
        for (Map.Entry<Integer, String> entry : DAYNAME_MAP.entrySet()) {
            final String dayNum = (entry.getKey() <= 9) ? "0" + entry.getKey() : entry.getKey().toString();
            builder.append("import com.aoc.days")
                    .append(year)
                    .append(".day")
                    .append(dayNum)
                    .append(".Day")
                    .append(entry.getValue())
                    .append(";\n");
        }
        return builder.toString();
    }

    private static void createDayPackage(final String basePkg, final int dayNum, final int year) throws ModuleException {
        final String packageName = "day" + (dayNum > 9 ? "" : 0) + dayNum;
        createNewDirectory(basePkg + "/" + packageName);
        final String dayName = DAYNAME_MAP.get(dayNum);
        createNewFileAndWriteToIt(basePkg + "/" + packageName + "/Solution" + dayName + ".java",
                String.format(FileTemplate.SOLUTION_BASE_TEMPLATE,
                        year,
                        packageName,
                        dayName,
                        dayName)
        );
        createNewFileAndWriteToIt(basePkg + "/" + packageName + "/Day" + dayName + ".java",
                String.format(FileTemplate.DAY_BASE_TEMPLATE,
                        year,
                        packageName,
                        dayName,
                        dayName,
                        dayName,
                        dayName,
                        year,
                        dayNum,
                        dayName)
        );
    }

    private static void createNewDirectory(final String directoryName) throws ModuleException {
        if (!new File(directoryName).mkdir()) {
            throw new ModuleException("Could not create directory for name: " + directoryName);
        }
    }

    private static void createNewFileAndWriteToIt(final String filename, final String content) throws ModuleException {
        final File file = new File(filename);
        try (final FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (final Exception e) {
            throw new ModuleException(e);
        }
    }
}
