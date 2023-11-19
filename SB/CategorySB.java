package SB;
import java.util.ArrayList;
import java.util.List;

public class CategorySB {
    private String categoryName;
    List<QuestionSB> questionList = new ArrayList<>();

    public CategorySB(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

}
