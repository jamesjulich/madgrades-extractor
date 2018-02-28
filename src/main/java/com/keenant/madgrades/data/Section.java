package com.keenant.madgrades.data;

import com.keenant.madgrades.utils.Room;
import com.keenant.madgrades.utils.SectionType;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class Section {
  private final int termCode;
  private final int courseNumber;
  private final SectionType sectionType;
  private final int sectionNumber;
  private final Schedule schedule;
  private final Room room;
  private final Map<Integer, String> instructors;

  public Section(int termCode, int courseNumber,
      SectionType sectionType, int sectionNumber, Schedule schedule,
      Room room, Map<Integer, String> instructors) {
    this.termCode = termCode;
    this.courseNumber = courseNumber;
    this.sectionType = sectionType;
    this.sectionNumber = sectionNumber;
    this.schedule = schedule;
    this.room = room;
    this.instructors = instructors;
  }

  public UUID generateUuid(CourseOffering offering) {
    String instructorsStr = instructors.keySet().stream()
        .sorted()
        .map(Object::toString)
        .collect(Collectors.joining());

    // section is weird because we rely on the parent UUID to generate its section UUID
    String uniqueStr = offering.generateUuid().toString() + sectionType + sectionNumber + schedule + room + instructorsStr;
    return UUID.nameUUIDFromBytes(uniqueStr.getBytes());
  }

  public boolean isCrossListed(DirSection other) {
    return courseNumber == other.getCourseNumber() &&
        sectionType == other.getSectionType() &&
        sectionNumber == other.getSectionNumber() &&
        Objects.equals(schedule, other.getSchedule()) &&
        Objects.equals(room, other.getRoom()) &&
        instructors.equals(other.getInstructors());
  }

  public int getTermCode() {
    return termCode;
  }

  public int getCourseNumber() {
    return courseNumber;
  }

  public SectionType getSectionType() {
    return sectionType;
  }

  public int getSectionNumber() {
    return sectionNumber;
  }

  public Schedule getSchedule() {
    return schedule;
  }

  public Optional<Room> getRoom() {
    return Optional.ofNullable(room);
  }

  public Map<Integer, String> getInstructors() {
    return instructors;
  }
}