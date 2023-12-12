import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ApiBookListModel {
    private String userId;

    private ArrayList<Object> collectionOfIsbns;

}



