package com.keenant.madgrades;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Constants {
  /** columns for PDFs at https://registrar.wisc.edu/grade-reports/ found through trial and error */
  public static final List<Float> GRADES_COLUMNS = IntStream.of(
      200, 215, 235, 280, 300, 330, 360, 385, 410, 435,
      460, 480, 510, 540, 560, 580, 610, 630, 660, 690
  ).mapToObj(i -> (float) i).collect(Collectors.toList());

  /** columns for PDFs at https://registrar.wisc.edu/grade-reports/ found through trial and error */
  public static final List<Float> GRADES_COLUMNS_2 = GRADES_COLUMNS.subList(4, GRADES_COLUMNS.size());

  /** columns for "Final DIR" PDF's https://registrar.wisc.edu/current-reports/ found through trial and error */
  public static final List<Float> DIR_COLUMNS = IntStream.of(
      55, 80, 95, 130, 150, 210, 295, 360, 420, 480, 550
  ).mapToObj(i -> (float) i).collect(Collectors.toList());

  /** columns for "Final DIR" PDF's specifically for 1124 */
  public static final List<Float> DIR_COLUMNS_1124 = IntStream.of(
      55, 80, 95, 130, 131, 220, 370, 440, 490, 520, 580
  ).mapToObj(i -> (float) i).collect(Collectors.toList());

  /** day abbreviation/character to day of week enum */
  public static final Map<String, DayOfWeek> STR_TO_DAY = new HashMap<String, DayOfWeek>() {{
    put("M", DayOfWeek.MONDAY);
    put("T", DayOfWeek.TUESDAY);
    put("W", DayOfWeek.WEDNESDAY);
    put("R", DayOfWeek.THURSDAY);
    put("F", DayOfWeek.FRIDAY);
    put("S", DayOfWeek.SATURDAY);
    put("N", DayOfWeek.SUNDAY);
  }};

  public static final Map<DayOfWeek, String> DAY_TO_STR = STR_TO_DAY.entrySet().stream()
      .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

  /** page which hosts links to grade distribution reports */
  public static final String GRADE_REPORTS_URL = "https://registrar.wisc.edu/grade-reports/";

  /** page which hosts links to dir reports */
  public static final String DIR_REPORTS_URL = "https://registrar.wisc.edu/current-reports/";

  /** page which hosts links to a few schedules */
  public static final String SCHEDULES_URL = "https://registrar.wisc.edu/schedule-of-classes-faculty/";

  /** page which contains a table of subject areas */
  public static final String SUBJECTS_URL = "https://registrar.wisc.edu/subjectarea/";
}
