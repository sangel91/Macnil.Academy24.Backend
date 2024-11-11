package macnil.academy.service;
import macnil.academy.controller.dto.EntryDTO;
import macnil.academy.model.EntryModel;
import macnil.academy.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;

    public EntryDTO saveEntry(EntryDTO entryDTO) {
      
        EntryModel entry = toModel(entryDTO);

       
        setDurataStatusColore(entry);

       
        EntryModel savedEntry = entryRepository.save(entry);
        return toDTO(savedEntry);
    }

    public List<EntryModel> getAllEntries() {
        return entryRepository.findAll();
    }

    public Optional<EntryModel> getEntryById(Long id) {
        return entryRepository.findById(id);
    }

    public EntryModel updateEntry(Long id, EntryModel updatedEntry) {
        return entryRepository.findById(id).map(entry -> {
            entry.setHourIn(updatedEntry.getHourIn());
            entry.setHourOut(updatedEntry.getHourOut());
            entry.setLocation(updatedEntry.getLocation());

            setDurataStatusColore(entry);

            return entryRepository.save(entry);
        }).orElse(null);
    }

    private void setDurataStatusColore(EntryModel entry) {
        if (entry.getHourIn() != null && entry.getHourOut() != null) {
            long durataMinuti = Duration.between(entry.getHourIn(), entry.getHourOut()).toMinutes();
            entry.setDurataMinuti((int) Math.min(durataMinuti, 480)); 
        } else {
            entry.setDurataMinuti(0); 
        }

 
        if (entry.getDurataMinuti() < 240) {
            entry.setStatus("Incompleto");
            entry.setColore("Rosso");
        } else if (entry.getDurataMinuti() >= 240 && entry.getDurataMinuti() < 480) {
            entry.setStatus("Mezza giornata");
            entry.setColore("Giallo");
        } else {
            entry.setStatus("Completo");
            entry.setColore("Verde");
        }
    }

    private EntryModel toModel(EntryDTO entryDTO) {
        return new EntryModel(
            entryDTO.getId(),
            entryDTO.getDate(),
            entryDTO.getHourIn(),
            entryDTO.getHourOut(),
            entryDTO.getLocation(),
            entryDTO.getDurataMinuti(),
            entryDTO.getStatus(),
            entryDTO.getColore()
        );
    }

    private EntryDTO toDTO(EntryModel entry) {
        return new EntryDTO(
            entry.getId(),
            entry.getDate(),
            entry.getHourIn(),
            entry.getHourOut(),
            entry.getLocation(),
            entry.getDurataMinuti(),
            entry.getStatus(),
            entry.getColore()
        );
    }
}
