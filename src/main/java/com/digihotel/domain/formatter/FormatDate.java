package com.digihotel.domain.formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatDate
{
    private static final String FORMAT_DD_MM_YYYY = "dd/MM/yyyy";

    private FormatDate()
    {

    }

    public static LocalDate getDate(String textDate)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_DD_MM_YYYY);

        return LocalDate.parse(textDate, pattern);
    }

    public static String getStringDate(LocalDate date)
    {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern(FORMAT_DD_MM_YYYY);

        return pattern.format(date);
    }
}