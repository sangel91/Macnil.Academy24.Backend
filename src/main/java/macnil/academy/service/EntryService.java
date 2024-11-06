package macnil.academy.service;

import macnil.academy.model.EntryModel;
import macnil.academy.repository.EntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Service
public class EntryService {

    @Autowired
    private EntryRepository entryRepository;


    public EntryModel saveEntry(EntryModel entry) {

        if (entry.getHourIn() != null && entry.getHourOut() != null) {
            long durataMinuti = Duration.between(entry.getHourIn(), entry.getHourOut()).toMinutes();
            entry.setDurataMinuti((int) Math.min(durataMinuti, 480)); // Limite di 8 ore (480 minuti)
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

        return entryRepository.save(entry);
    }

   
    public List<EntryModel> getAllEntries() {
        return entryRepository.findAll();
    }
}
