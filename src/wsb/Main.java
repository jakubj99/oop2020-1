package wsb;

import wsb.creatures.*;
import wsb.database.Connector;
import wsb.database.JDBCConnector;
import wsb.devices.*;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        Phone iphone = Phone.createIPhone( "8", 4.7);
        iphone.turnOn();


    }
}
