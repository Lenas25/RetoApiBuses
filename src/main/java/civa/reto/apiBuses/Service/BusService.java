package civa.reto.apiBuses.Service;

import civa.reto.apiBuses.dto.BusData;
import civa.reto.apiBuses.dto.MarcaData;
import civa.reto.apiBuses.exception.NotFound;
import civa.reto.apiBuses.model.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import civa.reto.apiBuses.repository.BusRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    private BusData mapBusToBusData(Bus bus) {
        return new BusData(
                bus.getId(),
                bus.getNumeroBus(),
                bus.getPlaca(),
                bus.getCaracteristicas(),
                bus.getCreated_at(),
                bus.isIs_active(),
                bus.getMarcabus() != null ? new MarcaData(bus.getMarcabus().getId(), bus.getMarcabus().getNombre()) : null
        );
    }

    public Page<BusData> findAll(Pageable pageable) {
        Page<Bus> pageResult = busRepository.findAll(pageable);
        List<BusData> busDataList = pageResult.getContent().stream()
                .map(this::mapBusToBusData)
                .collect(Collectors.toList());
        return new PageImpl<>(busDataList, pageable, pageResult.getTotalElements());
    }

    public BusData findById(Long id) {
        Bus busFinded = busRepository.findById(id).orElseThrow(() ->
                new NotFound("Bus with id " + id + " not found")
        );
        return mapBusToBusData(busFinded);
    }

    public Bus saveBus(Bus newBus) {
        return busRepository.save(newBus);
    }
}
