package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.model.ItemDM;
import cs.vapo.bringit.core.dao.model.ListDM;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class ListDataServiceTests {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @Autowired
    private ListDataService listDataService;

    @Test
    void findListById() {
        final String id = "1234";
        final ListDM list = listDataService.findListById(id);
        log.info("list owner: {}", list.getOwner().getId());
        Assertions.assertNotNull(list);
    }

    @Test
    void findListsByOwnerId() {
        final String ownerId = "1234";
        final List<ListDM> results = listDataService.findListsByOwnerId(ownerId);

        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals("1234", results.get(0).getId());
    }

    @Test
    void addItemToList() {
        final ItemDM item = new ItemDM();
        item.setName("Soda");
        item.setDescription("Can be different flavors");
        item.setItemCount(3);
        item.setImage("/this/is/a/path");

        listDataService.addItemToList("12345", item);
        final ListDM list = listDataService.findListById("12345");

        Assertions.assertEquals(list.getItems().size(), 1);
        Assertions.assertEquals(list.getItems().get(0).getDescription(), item.getDescription());
    }
}
