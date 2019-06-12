package nba_statistics.controllers.viewer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import nba_statistics.entities.PlayerMatchAchievements;
import nba_statistics.entities.Players;
import nba_statistics.entities.Seasons;
import nba_statistics.services.MatchesService;
import nba_statistics.services.PlayersService;
import nba_statistics.services.SeasonsService;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;
import static nba_statistics.others.Alerts.getAlertLessThanTopTenPlayers;
import static nba_statistics.others.Alerts.getAlertNoTopTenPlayers;

public class ListOfTop10Shooters implements Initializable {

    @FXML
    private ComboBox<String> seasonComboBox;
    @FXML
    private ListView<String> topTenListView;
    @FXML
    private Button backButton;
    @FXML
    private Button selectListButton;


    public void setVisibleLabelsTopTenSchooters() {
        topTenListView.setVisible(true);
    }

    public void setInvisibleLabelsTopTenSchooters() {
        topTenListView.setVisible(false);
    }

    public void changeScreenBack(Event event) throws IOException {
        Parent backParent = FXMLLoader.load(getClass().getResource("/DataViewer.fxml"));
        Scene backScene = new Scene(backParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(backScene);
        window.show();
    }

    private void initComboBoxSeasons() {
        SeasonsService seasonsService = new SeasonsService();
        ArrayList<String> seasons = seasonsService.getAllSeasonsName();
        seasonComboBox.setItems(FXCollections.observableArrayList(seasons));
    }

    public void selectListTopTenSchooters() {


        SeasonsService seasonsService = new SeasonsService();
        MatchesService matchesService = new MatchesService();
        PlayersService playersService = new PlayersService();

        String nameSeason = seasonComboBox.getValue();

        Seasons season = seasonsService.getSeason(nameSeason);

        List<PlayerMatchAchievements> playerMatchAchievements = matchesService.getAchievementsPlayersInSeason(season.getId());

        Map<Integer, Integer> map = selectTenPlayersData(playerMatchAchievements);
        List<Players> playersList;
        ObservableList<String> listString = FXCollections.observableArrayList();

        if (map.size() < 1) {
            setInvisibleLabelsTopTenSchooters();
            getAlertNoTopTenPlayers();
        } else {
            setVisibleLabelsTopTenSchooters();

            int i = 0;

            for (Map.Entry<Integer, Integer> mapData : map.entrySet()) {
                playersList = playersService.getPlayersById(mapData.getKey());
                setVisibleLabelsTopTenSchooters();

                i++;
                listString.add(i + ". " + playersList.get(0).getSurname() + " " + playersList.get(0).getName() + "\t\t Scored points: " + mapData.getValue());
                if (i == 10) break;
            }
            topTenListView.setItems(listString);
        }
        if (map.size() < 10 && map.size() > 0) getAlertLessThanTopTenPlayers();

    }


    public Map<Integer, Integer> selectTenPlayersData(List<PlayerMatchAchievements> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        int id = -1;

        for (int i = 0; i < list.size(); i++) {
            sum = 0;
            id = list.get(i).getPlayer().getId();

            for (int j = 0; j < list.size(); j++) {
                if (id == list.get(j).getPlayer().getId()) {
                    sum += list.get(j).getScoredPoints();
                    list.remove(j);
                    j--;
                }
            }
            map.put(id, sum);
        }

        Map<Integer, Integer> sortedMap = map.entrySet()
                .stream()
                .sorted(Collections.reverseOrder(comparingByValue()))
                .collect(Collectors.toMap(
                        e -> e.getKey(),
                        e -> e.getValue(),
                        (e1, e2) -> e2, LinkedHashMap::new));
        return sortedMap;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setInvisibleLabelsTopTenSchooters();
        initComboBoxSeasons();
    }
}
