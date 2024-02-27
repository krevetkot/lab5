package managers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import jakarta.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, LocalDate> {

    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String marshal(LocalDate v) throws Exception {
            return dateFormat.format(v);
    }

    @Override
    public LocalDate unmarshal(String v) throws Exception {
            return dateFormat.parse(v).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

}