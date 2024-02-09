package com.project.modulo4.service;

import com.project.modulo4.mapper.ClubMapper;
import com.project.modulo4.mapper.LeagueMapper;
import com.project.modulo4.models.club.dto.ClubDTO;
import com.project.modulo4.models.club.dto.CreateClubDTO;
import com.project.modulo4.models.club.dto.UpdateClubDTO;
import com.project.modulo4.models.club.model.ClubModel;
import com.project.modulo4.models.league.dto.LeagueDTO;
import com.project.modulo4.models.league.model.LeagueModel;
import com.project.modulo4.repository.LeagueRepository;
import com.project.modulo4.utils.exception.LeagueNotFoundException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class LeagueService {


    LeagueRepository leagueRepository = new LeagueRepository() {
        @Override
        public List<ClubModel> findClubsByLeague(long leagueId) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends LeagueModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends LeagueModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<LeagueModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public LeagueModel getOne(Long aLong) {
            return null;
        }

        @Override
        public LeagueModel getById(Long aLong) {
            return null;
        }

        @Override
        public LeagueModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends LeagueModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends LeagueModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends LeagueModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<LeagueModel> findAll() {
            return null;
        }

        @Override
        public List<LeagueModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends LeagueModel> S save(S entity) {
            return null;
        }

        @Override
        public Optional<LeagueModel> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(LeagueModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends LeagueModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<LeagueModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<LeagueModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends LeagueModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends LeagueModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends LeagueModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends LeagueModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends LeagueModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };

    LeagueMapper leagueMapper = new LeagueMapper() {
        @Override
        public LeagueDTO toDTO(LeagueModel leagueModel) {
            return null;
        }

        @Override
        public List<LeagueDTO> toDTO(List<LeagueModel> model) {
            return null;
        }

        @Override
        public LeagueModel toModel(LeagueDTO leagueDTO) {
            return null;
        }
    };


    private ClubMapper clubMapper = new ClubMapper() {
        @Override
        public ClubDTO toDTO(ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(CreateClubDTO createClubDTO) {
            return null;
        }

        @Override
        public ClubModel updateToModel(UpdateClubDTO updateClubDTO, ClubModel clubModel) {
            return null;
        }

        @Override
        public ClubModel toModel(ClubDTO clubDTO) {
            return null;
        }

        @Override
        public List<ClubDTO> toDTO(List<ClubModel> model) {
            return null;
        }
    };

    public List<LeagueDTO> getAll() {
        List<LeagueModel> leagues = leagueRepository.findAll();
        return leagues.stream().map(leagueMapper::toDTO).toList();
    }

    public LeagueDTO getById(Long leagueId) throws LeagueNotFoundException {
        Optional<LeagueModel> leagueOptional = leagueRepository.findById(leagueId);
        return leagueOptional.map(leagueMapper::toDTO).orElse(null);
    }

    public List<ClubDTO> findClubsByLeague(Long leagueId) throws LeagueNotFoundException {
        return clubMapper.toDTO(leagueRepository.findClubsByLeague(leagueId));
    }
}
