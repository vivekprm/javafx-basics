package modelChangeMVVM;

import javafx.beans.property.*;
import javafx.concurrent.Service;
import javafx.concurrent.Task;

public class URLTestViewModel {
    // Data elements
    private final StringProperty url = new SimpleStringProperty("");
    private final StringProperty statusCode = new SimpleStringProperty("");
    private final StringProperty loadTime = new SimpleStringProperty("");

    // Status elements
    private final BooleanProperty wasError = new SimpleBooleanProperty(false);
    private final StringProperty errorMessage = new SimpleStringProperty("");

    public StringProperty urlProperty() {
        return url;
    }

    public StringProperty statusCodeProperty() {
        return statusCode;
    }

    public StringProperty loadTimeProperty() {
        return loadTime;
    }

    public StringProperty errorMessageProperty() {
        return errorMessage;
    }

    public ReadOnlyBooleanProperty urlTestTaskRunningProperty() {
        return urlTestCommand.runningProperty();  // presented later
    }

    public ReadOnlyStringProperty urlTestTaskMessageProperty() {
        return urlTestCommand.messageProperty();  // presented later
    }

    public ReadOnlyDoubleProperty urlTestTaskProgressProperty() {
        return urlTestCommand.progressProperty();  // presented later
    }

    public void test() {
        urlTestCommand.restart();  // presented later
    }

    private final URLTestModel urlTestModel = new URLTestModel();

    private final Notifications notifications = new Notifications();

    public URLTestViewModel() {
        notifications.subscribe(Notifications.EVENT_MODEL_UPDATE,
                this,
                this::update);  // presented later
    }

    private final Service<Void> urlTestCommand = new Service<Void>() {
        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    updateProgress(0.1d, 1.0d);
                    updateMessage("Testing url " + url.get());
                    urlTestModel.testURL(url.get());
                    return null;
                }

                protected void failed() {
                    getException().printStackTrace();  // just in case
                }
            };
        }
    };

    private void update(String event) {
        urlTestModel.getUrlTestObject().ifPresent(
                (testObject) -> {
                    wasError.set(testObject.getWasError());
                    if (!testObject.getWasError()) {
                        statusCode.set(
                                "Status code: " +
                                        String.valueOf(testObject.getStatusCode())
                        );

                        loadTime.set(
                                String.valueOf(testObject.getLoadTime()) +
                                        " ms"
                        );

                        errorMessage.set(testObject.getErrorMessage());
                    } else {
                        statusCode.set("");  // use empty TextField, not 0
                        loadTime.set("");  // use empty TextField, not 0
                        errorMessage.set(testObject.getErrorMessage());
                    }
                });
    }
}
