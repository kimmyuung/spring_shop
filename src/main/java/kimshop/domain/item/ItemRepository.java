package kimshop.domain.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    List<ItemEntity> findByItemNm(String itemNm);

    @Query("select i from Item where i.itemDetail like %: itemDetail% order by i.price desc")
    List<ItemEntity> findByItemDetail(@Param("itemDetail") String itemDetail);

}
