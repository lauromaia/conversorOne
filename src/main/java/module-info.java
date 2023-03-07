module br.com.conversoronelauro.conversorone {
    requires javafx.controls;
    requires javafx.fxml;


    opens br.com.conversoronelauro.conversorone to javafx.fxml;
    exports br.com.conversoronelauro.conversorone;
    exports br.com.conversoronelauro.conversorone.ConversorMoeda;
    opens br.com.conversoronelauro.conversorone.ConversorMoeda to javafx.fxml;
}