package com.agile.mentorship.surveyApplication.converter;

import com.agile.mentorship.surveyApplication.dto.ChronoTagDto;
import com.agile.mentorship.surveyApplication.model.ChronoTag;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ChronoOrderTagConverter
implements MongoDbConverter<ChronoTag, ChronoTagDto> {
        Logger logger = Logger.getLogger("MongoDbConverter");

        @Override
        public ChronoTagDto convertToDto(ChronoTag chronoTag) {
            if (chronoTag == null) {
                throw new IllegalArgumentException("Source entity is NULL");
            }
            ChronoTagDto chronoTagDto;
            chronoTagDto = new ChronoTagDto();
            chronoTagDto.setId(Optional.ofNullable(chronoTag.getId())
                    .map(ObjectId::toString)
                    .orElse(null));
            chronoTagDto.setValue(chronoTag.getValue());
            chronoTagDto.setDefault(chronoTag.isDefault());
            chronoTagDto.setDisplayOrder(chronoTag.getDisplayOrder());
            chronoTagDto.setSetupId(chronoTag.getSetupId());
            return chronoTagDto;
        }

        @Override
        public ChronoTag convertToDb(ChronoTagDto chronoTagDto) {
            if (chronoTagDto == null) {
                throw new IllegalArgumentException("Source dto is NULL");
            }
            ChronoTag chronoTag = new ChronoTag();
            chronoTag.setId(Optional.of(chronoTagDto.getId())
                    .map(ObjectId::new)
                    .orElseGet(ObjectId::new));
            chronoTag.setValue(chronoTagDto.getValue());
            chronoTag.setSetupId(chronoTagDto.getSetupId());
            chronoTag.setDisplayOrder(chronoTagDto.getDisplayOrder());
            chronoTag.setDefault(chronoTagDto.isDefault());
            return chronoTag;
        }
    }
