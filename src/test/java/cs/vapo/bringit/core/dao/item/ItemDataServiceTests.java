package cs.vapo.bringit.core.dao.item;

import cs.vapo.bringit.core.dao.list.ListDataService;
import cs.vapo.bringit.core.dao.model.ItemDM;
import cs.vapo.bringit.core.dao.model.ListDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ItemDataServiceTests {

    @Autowired
    private ItemDataService itemDataService;

    @Autowired
    private ListDataService listDataService;

    @Test
    public void addItemToList() {
        final ItemDM item = new ItemDM();
        item.setName("Soda");
        item.setDescription("Can be different flavors");
        item.setItemCount(3);
        item.setImage("/this/is/a/path");
        final ListDM list = new ListDM();
        list.setId("12345");
        item.setList(list);

        itemDataService.saveItem(item);

        final ListDM savedList = listDataService.findListById("12345");
        // FIXME: not saving item to list
        Assertions.assertEquals(savedList.getItems().size(), 1);
    }
}
