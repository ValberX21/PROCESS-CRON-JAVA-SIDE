package firstpalace.processslice.Service;

import firstpalace.processslice.Repository.ProcessInventoryRepository;
import firstpalace.processslice.model.ProcessInventory;
import firstpalace.processslice.model.Product;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessLot
{

    private final ProcessInventoryRepository _processInventoryRepository;

    public ProcessLot(ProcessInventoryRepository processInventoryRepository)
    {
        this._processInventoryRepository = processInventoryRepository;
    }

    public Long process(List<Product> productList)
    {
        System.out.println("Processing lot...");

        double totalInventory = 0;

        for (int i = 0; i < productList.size(); i++) {
            totalInventory += productList.get(i).getPrice();
        }

        ProcessInventory inventory = new ProcessInventory(totalInventory);
        ProcessInventory saved = _processInventoryRepository.save(inventory);

        return saved.getId();

    }
}
