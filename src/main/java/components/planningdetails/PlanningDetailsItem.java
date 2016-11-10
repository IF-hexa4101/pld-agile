package components.planningdetails;

import components.events.AddWaypointAction;
import components.events.CancelAddWaypointAction;
import components.events.RemoveWaypointAction;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import models.AbstractWaypoint;
import models.Planning;
import models.Route;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class PlanningDetailsItem extends AnchorPane {
    @FXML
    protected StackPane pathBefore;
    @FXML
    protected VBox dataBefore;
    @FXML
    protected StackPane pathAfter;
    @FXML
    protected VBox dataAfter;
    @FXML
    protected AnchorPane pathDuration;
    @FXML
    protected AnchorPane waitDuration;
    @FXML
    protected Button addButton;
    @FXML
    protected Button cancelAddButton;
    @FXML
    protected Button removeButton;

    private final SimpleObjectProperty<Route> item = new SimpleObjectProperty<>(this, "item", null);
    private final SimpleObjectProperty<Planning> planning = new SimpleObjectProperty<>(this, "planning", null);
    private final SimpleIntegerProperty index = new SimpleIntegerProperty(this, "index", 0);
    private final SimpleBooleanProperty displayPathBefore = new SimpleBooleanProperty(this, "displayPathBefore", true);
    private final SimpleBooleanProperty displayDataBefore = new SimpleBooleanProperty(this, "displayDataBefore", true);
    private final SimpleBooleanProperty displayPathAfter = new SimpleBooleanProperty(this, "displayPathAfter", true);
    private final SimpleBooleanProperty displayDataAfter = new SimpleBooleanProperty(this, "displayDataAfter", true);
    private final SimpleBooleanProperty displayAddButton = new SimpleBooleanProperty(this, "displayAddButton", true);
    private final SimpleBooleanProperty displayCancelAddButton = new SimpleBooleanProperty(this, "displayCancelAddButton", false);
    private final SimpleBooleanProperty displayRemoveButton = new SimpleBooleanProperty(this, "displayRemoveButton", true);

    public PlanningDetailsItem() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/components/planningdetails/PlanningDetailsItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        this.pathBefore.managedProperty().bindBidirectional(this.pathBefore.visibleProperty());
        this.dataBefore.managedProperty().bindBidirectional(this.dataBefore.visibleProperty());
        this.pathAfter.managedProperty().bindBidirectional(this.pathAfter.visibleProperty());
        this.dataAfter.managedProperty().bindBidirectional(this.dataAfter.visibleProperty());
        this.addButton.managedProperty().bindBidirectional(this.addButton.visibleProperty());
        this.cancelAddButton.managedProperty().bindBidirectional(this.cancelAddButton.visibleProperty());
        this.removeButton.managedProperty().bindBidirectional(this.removeButton.visibleProperty());

        this.pathBefore.visibleProperty().bindBidirectional(this.displayPathBeforeProperty());
        this.dataBefore.visibleProperty().bindBidirectional(this.displayDataBeforeProperty());
        this.pathAfter.visibleProperty().bindBidirectional(this.displayPathAfterProperty());
        this.dataAfter.visibleProperty().bindBidirectional(this.displayDataAfterProperty());
        this.addButton.visibleProperty().bindBidirectional(this.displayAddButtonProperty());
        this.cancelAddButton.visibleProperty().bindBidirectional(this.displayCancelAddButtonProperty());
        this.removeButton.visibleProperty().bindBidirectional(this.displayRemoveButtonProperty());
    }

    /**
     * @return The observable property for the route displayed by this item.
     */
    public final SimpleObjectProperty<Route> itemProperty() {
        return this.item;
    }

    public final void setItem(Route value) {
        this.itemProperty().setValue(value);
    }

    public final Route getItem() {
        return this.itemProperty().getValue();
    }

    /**
     * @return The observable property for the planning containing the currently
     * displayed item.
     */
    @NotNull
    public final SimpleObjectProperty<Planning> planningProperty() {
        return this.planning;
    }

    @NotNull
    public final void setPlanning(@NotNull Planning value) {
        this.planningProperty().setValue(value);
    }

    @NotNull
    public final Planning getPlanning() {
        return this.planningProperty().getValue();
    }

    @NotNull
    public final SimpleIntegerProperty indexProperty() {
        return this.index;
    }

    public final void setIndex(int value) {
        this.indexProperty().setValue(value);
    }

    public final int getIndex() {
        return this.indexProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayPathBeforeProperty() {
        return this.displayPathBefore;
    }

    public final void setDisplayPathBefore(boolean value) {
        this.displayPathBeforeProperty().setValue(value);
    }

    public final boolean getDisplayPathBefore() {
        return this.displayPathBeforeProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayDataBeforeProperty() {
        return this.displayDataBefore;
    }

    public final void setDisplayDataBefore(boolean value) {
        this.displayDataBeforeProperty().setValue(value);
    }

    public final boolean getDisplayDataBefore() {
        return this.displayDataBeforeProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayPathAfterProperty() {
        return this.displayPathAfter;
    }

    public final void setDisplayPathAfter(boolean value) {
        this.displayPathAfterProperty().setValue(value);
    }

    public final boolean getDisplayPathAfter() {
        return this.displayPathAfterProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayDataAfterProperty() {
        return this.displayDataAfter;
    }

    public final void setDisplayDataAfter(boolean value) {
        this.displayDataAfterProperty().setValue(value);
    }

    public final boolean getDisplayDataAfter() {
        return this.displayDataAfterProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayAddButtonProperty() {
        return this.displayAddButton;
    }

    public final void setDisplayAddButton(boolean value) {
        this.displayAddButtonProperty().setValue(value);
    }

    public final boolean getDisplayAddButton() {
        return this.displayAddButtonProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayCancelAddButtonProperty() {
        return this.displayCancelAddButton;
    }

    public final void setDisplayCancelAddButton(boolean value) {
        this.displayCancelAddButtonProperty().setValue(value);
    }

    public final boolean getDisplayCancelAddButton() {
        return this.displayCancelAddButtonProperty().getValue();
    }

    @NotNull
    public final SimpleBooleanProperty displayRemoveButtonProperty() {
        return this.displayRemoveButton;
    }

    public final void setDisplayRemoveButton(boolean value) {
        this.displayRemoveButtonProperty().setValue(value);
    }

    public final boolean getDisplayRemoveButton() {
        return this.displayRemoveButtonProperty().getValue();
    }

    public void onRemoveButtonAction(@NotNull ActionEvent actionEvent) {
        Route item = this.getItem();
        if (item == null) {
            return;
        }
        AbstractWaypoint startWaypoint = item.getStartWaypoint();
        if (startWaypoint == null) {
            return;
        }
        fireEvent(new RemoveWaypointAction(startWaypoint));
    }

    public void onAddButtonAction(@NotNull ActionEvent actionEvent) {
        fireEvent(new AddWaypointAction(this.getIndex()));
    }

    public void onCancelAddButtonAction(@NotNull ActionEvent actionEvent) {
        fireEvent(new CancelAddWaypointAction());
    }
}
