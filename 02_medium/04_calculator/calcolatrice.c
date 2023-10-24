#include <gtk/gtk.h>

// Function to perform addition
double add(double x, double y) {
    return x + y;
}

// Function to perform subtraction
double subtract(double x, double y) {
    return x - y;
}

// Function to perform multiplication
double multiply(double x, double y) {
    return x * y;
}

// Function to perform division
double divide(double x, double y) {
    if (y == 0) {
        // You can choose how to handle this error
        return 0.0;
    }
    return x / y;
}

// Callback function for the "Calculate" button
void calculate(GtkWidget *widget, gpointer data) {
    GtkWidget *result_label = (GtkWidget *)data;
    GtkWidget *num1_entry = (GtkWidget *)gtk_builder_get_object(builder, "num1_entry");
    GtkWidget *num2_entry = (GtkWidget *)gtk_builder_get_object(builder, "num2_entry");
    GtkWidget *operation_combo = (GtkWidget *)gtk_builder_get_object(builder, "operation_combo");

    const gchar *operation = gtk_combo_box_get_active_text(GTK_COMBO_BOX(operation_combo));
    double num1 = atof(gtk_entry_get_text(GTK_ENTRY(num1_entry));
    double num2 = atof(gtk_entry_get_text(GTK_ENTRY(num2_entry));

    double result;
    if (g_strcmp0(operation, "Add") == 0) {
        result = add(num1, num2);
    } else if (g_strcmp0(operation, "Subtract") == 0) {
        result = subtract(num1, num2);
    } else if (g_strcmp0(operation, "Multiply") == 0) {
        result = multiply(num1, num2);
    } else if (g_strcmp0(operation, "Divide") == 0) {
        result = divide(num1, num2);
    } else {
        g_warning("Invalid operation");
        return;
    }

    gchar *result_str = g_strdup_printf("Result: %.2lf", result);
    gtk_label_set_text(GTK_LABEL(result_label), result_str);
    g_free(result_str);
}

static GtkBuilder *builder;

int main(int argc, char *argv[]) {
    // Initialize GTK
    gtk_init(&argc, &argv);

    // Load the GUI from Glade XML file
    builder = gtk_builder_new();
    gtk_builder_add_from_file(builder, "calculator.glade", NULL);

    // Get the main window
    GtkWidget *window = GTK_WIDGET(gtk_builder_get_object(builder, "window"));

    // Connect signals
    gtk_builder_connect_signals(builder, NULL);

    // Show the main window
    g_object_unref(builder);
    gtk_widget_show(window);

    // Start the GTK main loop
    gtk_main();

    return 0;
}
```

In this example, we use a Glade XML file (`calculator.glade`) to define the GUI layout. You need to create this Glade file with the appropriate widgets (labels, buttons, text entries, etc.). Then, in the `calculate` callback function, we fetch the user's input from the GUI elements and perform the calculation. The result is displayed on a label in the GUI.

Remember to install GTK and set up your development environment properly before compiling and running this code. The Glade XML file should match the widget names used in the code. This is a basic example, and you can expand upon it to create a more feature-rich calculator with additional functions and error handling.