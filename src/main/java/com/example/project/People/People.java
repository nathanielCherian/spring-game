package com.example.project.People;

import com.example.project.Database.Column;
import com.example.project.Database.Table;

import java.util.Arrays;

public class People {

    public static void main(String[] args) {

        Table people = new Table("People")
                .addColumn(new Column("id", Column.INTEGER).isPrimaryKey().isUnique())
                .addColumn(new Column("name", Column.STRING).isNotNull())
                .addColumn(new Column("school", Column.STRING))
                .create();

        people.createRow(new String[]{"name", "school"}, new Object[]{"Nathaniel C", "Del Norte"});
        Object[][] tableData = people.getFullTable();
        System.out.println(Arrays.deepToString(tableData));


    }

}
