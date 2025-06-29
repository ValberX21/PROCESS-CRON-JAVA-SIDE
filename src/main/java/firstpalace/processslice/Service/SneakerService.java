package firstpalace.processslice.Service;

import firstpalace.processslice.Repository.SneakerRepository;
import firstpalace.processslice.model.Sneaker;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SneakerService {

    private final SneakerRepository _sneakerRepository;

    public SneakerService(SneakerRepository sneakerRepository)
    {
        this._sneakerRepository = sneakerRepository;
    }

    public List<Sneaker> listAllSneaker(){
        return _sneakerRepository.findAll();
    }
}
