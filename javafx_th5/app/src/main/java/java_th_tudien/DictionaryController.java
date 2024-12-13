package java_th_tudien;

import java.util.HashMap;
import java.util.Map;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class DictionaryController {

     @FXML
    private TextField searchField;
    @FXML
    private TextField meaningField;
    @FXML
    private TextField pronunciationField;
    @FXML
    private TextArea additionalInfoField;

    
    private Map<String, String[]> dictionary = new HashMap<>();

    public void initialize() {
        dictionary.put("apple", new String[]{"Quả táo", "", "là một loại trái cây ăn quả có nhiều vitamin"});
        dictionary.put("banana", new String[]{"Quả chuối", "", "là một loại trái cây có vỏ vàng, thường ăn khi chín"});
        dictionary.put("cat", new String[]{"Con mèo", "", "là một loài động vật nuôi làm thú cưng"});
        dictionary.put("dog", new String[]{"Con chó", "", "là loài động vật nuôi phổ biến, thường được gọi là người bạn trung thành"});
        dictionary.put("car", new String[]{"Xe hơi", "", "là một phương tiện giao thông chạy bằng động cơ"});
        dictionary.put("house", new String[]{"Ngôi nhà", "", "là nơi ở của con người"});
        dictionary.put("computer", new String[]{"Máy tính", "", "là một thiết bị điện tử dùng để xử lý thông tin"});
        dictionary.put("book", new String[]{"Cuốn sách", "", "là một vật phẩm chứa thông tin, kiến thức hoặc câu chuyện"});
        dictionary.put("school", new String[]{"Trường học", "", "là nơi học tập của học sinh"});
        dictionary.put("tree", new String[]{"Cây", "", "là một loài thực vật có thân gỗ, lá và cành"});
        dictionary.put("river", new String[]{"Con sông", "", "là một dòng nước chảy dài và rộng, thường đổ ra biển"});
        dictionary.put("mountain", new String[]{"Ngọn núi", "", "là một khối đất cao, thường có đỉnh nhọn"});
        dictionary.put("flower", new String[]{"Hoa", "", "là phần của cây có màu sắc và mùi thơm đẹp"});
        dictionary.put("sun", new String[]{"Mặt trời", "", "là ngôi sao trung tâm của hệ mặt trời"});

        
    }
    @FXML
    private void searchWord() {
        String word = searchField.getText().toLowerCase();
        if (dictionary.containsKey(word)) {
            String[] wordInfo = dictionary.get(word);
            meaningField.setText(wordInfo[0]);
            pronunciationField.setText(wordInfo[1]);
            additionalInfoField.setText(wordInfo[2]);
        } else {
            meaningField.setText("Not found");
            pronunciationField.setText("");
            additionalInfoField.setText("");
        }
    }
    @FXML
    private void addWord(){
        Dialog<Void> dialog = new Dialog<>();
        dialog.setTitle("Thêm từ mới");
        dialog.setHeaderText("nhập ngữ nghĩa từ");

        GridPane grid = new GridPane();
        TextField wordField = new TextField();
        wordField.setPromptText("Từ");

        TextField translationField = new TextField();
        translationField.setPromptText("Dịch");

        TextArea descriptionField = new TextArea();
        descriptionField.setPromptText("Mô tả");
        descriptionField.setPrefRowCount(4);

        grid.add(new Label("Từ:"), 0, 0);
        grid.add(wordField, 1, 0);
        grid.add(new Label("Dịch từ:"), 0, 1);
        grid.add(translationField, 1, 1);
        grid.add(new Label("Mô tả:"), 0, 2);
        grid.add(descriptionField, 1, 2);

        dialog.getDialogPane().setContent(grid);

        ButtonType okButtonType = new ButtonType("Thêm", ButtonBar.ButtonData.OK_DONE);
        ButtonType cancelButtonType = new ButtonType("Xóa", ButtonBar.ButtonData.CANCEL_CLOSE);

        dialog.getDialogPane().getButtonTypes().addAll(okButtonType, cancelButtonType);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == okButtonType) {
                String word = wordField.getText().trim();
                String translation = translationField.getText().trim();
                String description = descriptionField.getText().trim();

                if (!word.isEmpty() && !translation.isEmpty() && !description.isEmpty()) {

                    dictionary.put(word, new String[]{translation, "", description});
                    System.out.println("Đã thêm: " + word + " - " + translation + " - " + description);
                } else {
                    
                    showAlert("Error", "All fields must be filled in");
                }
            }
            return null;
        });

        dialog.showAndWait();
    }
     private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}