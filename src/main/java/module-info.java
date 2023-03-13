module br.com.conversoronelauro.conversorone {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens br.com.conversoronelauro.conversorone to javafx.fxml;
    exports br.com.conversoronelauro.conversorone;
    exports br.com.conversoronelauro.conversorone.ConversorMoeda;
    opens br.com.conversoronelauro.conversorone.ConversorMoeda to javafx.fxml;
    exports br.com.conversoronelauro.conversorone.Controllers;
    opens br.com.conversoronelauro.conversorone.Controllers to javafx.fxml;
}