package com.example.combination.file.service.analyze;

import com.example.combination.domain.GameInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class EachCompareAnalyzer extends CompareAnalyzerAbstract {

    public void compareEachGroup(List<GameInfo> controlNumberSetGroup, List<GameInfo> experimentalNumberSetGroup) {
        for (GameInfo controlNumberSet : controlNumberSetGroup) {

            for (GameInfo experimentalNumberSet : experimentalNumberSetGroup) {

                compareEachNumberSets(controlNumberSet, experimentalNumberSet);
            }
        }
    }

}
