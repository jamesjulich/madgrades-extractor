package com.keenant.madgrades.data;

import com.keenant.madgrades.util.CsvWriter;
import com.keenant.madgrades.util.Serializer;
import com.keenant.madgrades.util.SqlWriter;
import java.util.Arrays;
import java.util.Objects;

public class InstructorBean {
  public static final Serializer<InstructorBean> SERIALIZER = bean -> Arrays.asList(
      bean.id,
      bean.name
  );
  public static final CsvWriter<InstructorBean> CSV_WRITER = new CsvWriter<>(
      "id,name", SERIALIZER
  );
  public static final SqlWriter<InstructorBean> SQL_WRITER = new SqlWriter<>(
      "instructors", SERIALIZER
  );

  private String id;
  private String name;

  public InstructorBean(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public InstructorBean() {

  }

  @Override
  public boolean equals(Object o) {
    return o instanceof InstructorBean && id.equals(((InstructorBean) o).id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }
}