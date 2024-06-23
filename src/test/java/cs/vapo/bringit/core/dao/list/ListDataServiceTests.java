package cs.vapo.bringit.core.dao.list;

import cs.vapo.bringit.core.dao.model.ItemDM;
import cs.vapo.bringit.core.dao.model.ListDM;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
class ListDataServiceTests {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().getClass());

    @Autowired
    private ListDataService listDataService;

    @Test
    void findListById() {
        final long id = 1234;
        final ListDM list = listDataService.findListById(id);
        log.info("list owner: {}", list.getOwner().getId());
        Assertions.assertNotNull(list);
    }

    @Test
    void findListsByOwnerId() {
        final long ownerId = 1234L;
        final List<ListDM> results = listDataService.findListsByOwnerId(ownerId);

        Assertions.assertEquals(2, results.size());
        Assertions.assertEquals(1234L, results.get(0).getId());
        Assertions.assertEquals(1234L, results.get(0).getOwner().getId());
    }

    @Test
    void addItemToList() {
        final ItemDM item = new ItemDM();
        item.setName("Soda");
        item.setDescription("Can be different flavors");
        item.setItemCount(3);
        item.setImage("/this/is/a/path");

        listDataService.addItemToList(12345L, item);
        final ListDM list = listDataService.findListById(12345);

        Assertions.assertEquals(list.getItems().size(), 1);
        Assertions.assertEquals(list.getItems().get(0).getDescription(), item.getDescription());
    }

    @Test
    void createList() {
        final LocalDate eventDate = LocalDate.now();
        final ListDM list = new ListDM();
        list.setTitle("This is a title");
        list.setEventDate(eventDate);

        final ListDM savedList = listDataService.createList(1000001, list);
        Assertions.assertEquals(eventDate, savedList.getEventDate());
        Assertions.assertEquals(list.getTitle(), savedList.getTitle());
    }

    @Test
    void createListOwnerNotExists() {
        final LocalDate eventDate = LocalDate.now();
        final ListDM list = new ListDM();
        list.setTitle("This is a title");
        list.setEventDate(eventDate);

        Assertions.assertThrows(EntityNotFoundException.class,
                // do not add this userId to test data
                () -> listDataService.createList(938383838, list));
    }
}
