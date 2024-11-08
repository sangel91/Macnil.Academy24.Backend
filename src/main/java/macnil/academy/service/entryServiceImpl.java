package macnil.academy.service;

import macnil.academy.model.entryModel;
import macnil.academy.repository.entryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class entryServiceImpl implements entryService {

    @Autowired
    private entryRepository entryRepository;

    @Override
    public Iterable<entryModel> getAllEntries() {
        return entryRepository.findAll();
    }

    @Override
    public Optional<entryModel> getEntryById(Integer id) {
        return entryRepository.findById(id);
    }

    @Override
    public entryModel saveEntry(entryModel entry) {
        if (entry.getHour_out() == null) {
            entry.setHour_out(null); // Imposto hour_out a null se non arriva niente
        }
        return entryRepository.save(entry);
    }

    @Override
    public entryModel updateEntry(Integer id, entryModel entryDetails) {
        entryModel entry = entryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Entry not found with id " + id));

        entry.setDate(entryDetails.getDate());
        entry.setHour_in(entryDetails.getHour_in());  // Modificato hourIn a hour_in

        if (entryDetails.getHour_out() != null) {  // Modifico hour_out solo se è presente un nuovo valore
            entry.setHour_out(entryDetails.getHour_out());
        }

        entry.setNotes(entryDetails.getNotes());
        entry.setLocation(entryDetails.getLocation());
        entry.setUser_id(entryDetails.getUser_id());  // Modificato userId a user_id

        return entryRepository.save(entry);
    }

    @Override
    public void deleteEntry(Integer id) {
        entryRepository.deleteById(id);
    }
}
