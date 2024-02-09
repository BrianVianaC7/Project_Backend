package com.project.modulo4.service;

import com.project.modulo4.mapper.NationMapper;
import com.project.modulo4.models.nation.dto.NationDTO;
import com.project.modulo4.models.nation.model.NationModel;
import com.project.modulo4.repository.NationRepository;
import com.project.modulo4.utils.exception.NationNotFoundException;
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
public class NationService {


    NationRepository nationRepository = new NationRepository() {
        @Override
        public void flush() {

        }

        @Override
        public <S extends NationModel> S saveAndFlush(S entity) {
            return null;
        }

        @Override
        public <S extends NationModel> List<S> saveAllAndFlush(Iterable<S> entities) {
            return null;
        }

        @Override
        public void deleteAllInBatch(Iterable<NationModel> entities) {

        }

        @Override
        public void deleteAllByIdInBatch(Iterable<Long> longs) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public NationModel getOne(Long aLong) {
            return null;
        }

        @Override
        public NationModel getById(Long aLong) {
            return null;
        }

        @Override
        public NationModel getReferenceById(Long aLong) {
            return null;
        }

        @Override
        public <S extends NationModel> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends NationModel> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public <S extends NationModel> List<S> saveAll(Iterable<S> entities) {
            return null;
        }

        @Override
        public List<NationModel> findAll() {
            return null;
        }

        @Override
        public List<NationModel> findAllById(Iterable<Long> longs) {
            return null;
        }

        @Override
        public <S extends NationModel> S save(S entity) {
            return null;
        }

        @Override
        public Optional<NationModel> findById(Long aLong) {
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
        public void delete(NationModel entity) {

        }

        @Override
        public void deleteAllById(Iterable<? extends Long> longs) {

        }

        @Override
        public void deleteAll(Iterable<? extends NationModel> entities) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public List<NationModel> findAll(Sort sort) {
            return null;
        }

        @Override
        public Page<NationModel> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends NationModel> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends NationModel> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends NationModel> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends NationModel> boolean exists(Example<S> example) {
            return false;
        }

        @Override
        public <S extends NationModel, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
            return null;
        }
    };


    NationMapper nationMapper = new NationMapper() {
        @Override
        public NationDTO toDTO(NationModel nationModel) {
            return null;
        }

        @Override
        public NationModel toModel(NationDTO nationDTO) {
            return null;
        }

        @Override
        public List<NationDTO> toDTO(List<NationModel> model) {
            return null;
        }
    };


    public List<NationDTO> getAll() {
        List<NationModel> nations = nationRepository.findAll();
        return nations.stream().map(nationMapper::toDTO).toList();
    }

    public NationDTO getById(Long nationId) throws NationNotFoundException {
        Optional<NationModel> nationOptional = nationRepository.findById(nationId);
        return nationOptional.map(x -> nationMapper.toDTO(x)).orElse(null);
    }
}
