package macnil.academy.service;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import macnil.academy.mapper.BroadcastMapper;
import macnil.academy.model.Broadcast;
import macnil.academy.repository.BroadcastRepository;

@Service
public class BroadcastService {

    @Autowired
    BroadcastRepository broadcastRepository;

    @Autowired
    BroadcastMapper broadcastMapper;

    public Broadcast create(Broadcast broadcast){
        return broadcastRepository.save(broadcast);
    }

    public Broadcast read(Long id) throws NoSuchElementException{
        Broadcast broadcast = broadcastRepository.findById(id).orElseThrow();
        return broadcast;
    }

    public Broadcast update(Broadcast broadcast) throws NoSuchElementException {
        Broadcast oldBroadcast = broadcastRepository.findById(broadcast.getId()).orElseThrow();
        Broadcast updatedBroadcast = broadcastMapper.updateOldBroadcastWithNewOne(oldBroadcast, broadcast);
        return broadcastRepository.save(updatedBroadcast);
    }
    
    public void delete(Long id) throws NoSuchElementException {
        Broadcast oldBroadcast = broadcastRepository.findById(id).orElseThrow();
        broadcastRepository.delete(oldBroadcast);
    }

    public List<Broadcast> readAll(Integer number) {
        List<Broadcast> broadcasts = broadcastRepository.findAll();
        if(number==null || number<1)
            return broadcasts;
        else {
            return broadcasts.stream().limit(number).collect(Collectors.toList());
        }
    }

}