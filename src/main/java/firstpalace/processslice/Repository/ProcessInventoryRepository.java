package firstpalace.processslice.Repository;

import firstpalace.processslice.model.ProcessInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessInventoryRepository  extends JpaRepository<ProcessInventory, Long> {
}
