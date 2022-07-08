package kimshop.dto;


import kimshop.domain.item.ItemSellStatus;
import lombok.*;

@Getter@Setter@ToString
@NoArgsConstructor@AllArgsConstructor
public class ItemDto {

    private int ino;


    private String itemNm;


    private int price;


    private int stockNum;


    private String itemDetail;


    private ItemSellStatus itemSellStatus;
}
