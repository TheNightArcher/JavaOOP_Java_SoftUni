package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.Repository;
import glacialExpedition.repositories.StateRepository;


import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private final Repository<Explorer> explorerRepository;
    private final StateRepository stateRepository;

    int exploredStatesCount = 0;

    public ControllerImpl() {
        explorerRepository = new ExplorerRepository();
        stateRepository = new StateRepository();
    }

    @Override
    public String addExplorer(String type, String explorerName) {
        Explorer explorer;
        switch (type) {
            case "AnimalExplorer":
                explorer = new AnimalExplorer(explorerName);
                break;
            case "GlacierExplorer":
                explorer = new GlacierExplorer(explorerName);
                break;
            case "NaturalExplorer":
                explorer = new NaturalExplorer(explorerName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
        }
        explorerRepository.add(explorer);
        return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
    }

    @Override
    public String addState(String stateName, String... exhibits) {
        State state = new StateImpl(stateName);
        Collection<String> stateExhibits = state.getExhibits();
        Collections.addAll(stateExhibits, exhibits);
        this.stateRepository.add(state);
        return String.format(ConstantMessages.STATE_ADDED, stateName);
    }

    @Override
    public String retireExplorer(String explorerName) {
        Explorer explorer = explorerRepository.byName(explorerName);

        if (explorer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
        }
        this.explorerRepository.remove(explorer);
        return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
    }

    @Override
    public String exploreState(String stateName) {

        Collection<Explorer> explorers = explorerRepository.getCollection().stream()
                .filter(e -> e.getEnergy() > 50).collect(Collectors.toList());

        if (explorers.size() == 0) {
            throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
        }
        Mission mission = new MissionImpl();
        State state = stateRepository.byName(stateName);

        mission.explore(state, explorers);
        exploredStatesCount++;
        int retiredExplorers = 0;
        for (Explorer explorer : explorers) {
            if (explorer.getEnergy() == 0) {
                retiredExplorers++;
            }
        }
        return String.format(ConstantMessages.STATE_EXPLORER, stateName, retiredExplorers);
    }

    @Override
    public String finalResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredStatesCount))
                .append(System.lineSeparator())
                .append(ConstantMessages.FINAL_EXPLORER_INFO);

        Collection<Explorer> explorers = this.explorerRepository.getCollection();
        for (Explorer explorer : explorers) {
            sb.append(System.lineSeparator());
            sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, explorer.getName()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, explorer.getEnergy()))
                    .append(System.lineSeparator());

            if (explorer.getSuitcase().getExhibits().isEmpty()) {
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
            } else {
                sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
                        String.join(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS_DELIMITER, explorer.getSuitcase().getExhibits())));
            }
        }
        return sb.toString();
    }
}
