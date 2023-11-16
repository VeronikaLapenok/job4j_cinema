package ru.job4j.cinema.service;

import net.jcip.annotations.ThreadSafe;
import org.springframework.stereotype.Service;
import ru.job4j.cinema.dto.FilmSessionDto;
import ru.job4j.cinema.model.FilmSession;
import ru.job4j.cinema.repository.FilmRepository;
import ru.job4j.cinema.repository.FilmSessionRepository;
import ru.job4j.cinema.repository.HallRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
@ThreadSafe
public class SimpleFilmSessionService implements FilmSessionService {
    private final FilmSessionRepository filmSessionRepository;
    private final FilmRepository filmRepository;
    private final HallService hallService;

    public SimpleFilmSessionService(FilmSessionRepository filmSessionRepository,
                                    FilmRepository filmRepository, HallService hallService) {
        this.filmSessionRepository = filmSessionRepository;
        this.filmRepository = filmRepository;
        this.hallService = hallService;
    }

    @Override
    public Optional<FilmSessionDto> findById(int id) {
        var optionalFilmSessionDto = filmSessionRepository.findById(id);
        if (optionalFilmSessionDto.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(new FilmSessionDto(
                optionalFilmSessionDto.get().getId(),
                filmRepository.findById(optionalFilmSessionDto.get().getFilmId()).get().getName(),
                hallService.findById(optionalFilmSessionDto.get().getHallsId()).get().getName(),
                optionalFilmSessionDto.get().getStart(),
                optionalFilmSessionDto.get().getEnd(),
                optionalFilmSessionDto.get().getPrice()));
    }

    @Override
    public Collection<FilmSessionDto> findAll() {
        List<FilmSessionDto> filmSessionDtoList = new ArrayList<>();
        for (FilmSession filmSession : filmSessionRepository.findAll()) {
            filmSessionDtoList.add(new FilmSessionDto(
                    filmSession.getId(),
                    filmRepository.findById(filmSession.getId()).get().getName(),
                    hallService.findById(filmSession.getHallsId()).get().getName(),
                    filmSession.getStart(),
                    filmSession.getEnd(),
                    filmSession.getPrice()));
        }
        return filmSessionDtoList;
    }
}
