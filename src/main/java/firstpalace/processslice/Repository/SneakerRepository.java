package firstpalace.processslice.Repository;

import firstpalace.processslice.model.ProcessInventory;
import firstpalace.processslice.model.Sneaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SneakerRepository  extends JpaRepository<Sneaker, Long> {
}
