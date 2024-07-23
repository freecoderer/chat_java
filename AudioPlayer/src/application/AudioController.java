package application;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class AudioController implements Initializable {
	AudioClip clip;
	MediaPlayer mediaPlayer;
	MediaView mediaView;
	File musicFile = null;
	Duration totalDuration;
	File imageFilePausePlay;
	String localUrl;
	Double totalTimeOfMusic ;
	boolean repeat = false;
	Duration duration;
	ToggleButton tb = new ToggleButton();
	ToggleGroup group = new ToggleGroup();
	@FXML
	ToggleButton browse;
	@FXML
	ToggleButton playpauseButton;
	@FXML
	AnchorPane page;
	@FXML
	Label musicBox;
	@FXML
	Label playTime;
	@FXML
	Label durationLabel;
	@FXML
	ImageView playPuseImage;
	@FXML
	Slider volumeSlider;
	@FXML
	Slider seekSlider;

	@FXML
	public void browseButton() {

		try {
			FileChooser fc = new FileChooser();
			// fc.getExtensionFilters().add(new
			// FileChooser.ExtensionFilter(".mp3","*.wmv"));
			// fc.getExtensionFilters().addAll(new
			// FileChooser.ExtensionFilter("MP3", "*.mp3"),new
			// FileChooser.ExtensionFilter("WMV", "*.wmv"));
			musicFile = fc.showOpenDialog(null);
			if (musicFile != null) {
				String path = musicFile.getAbsolutePath();

				path = path.replace("\\", "/");
				Media media = new javafx.scene.media.Media(new File(path)
						.toURI().toString());

				mediaPlayer = new MediaPlayer(media);
				musicBox.setText(path);
			}

			// musicBox.setText(selectedFile.getAbsolutePath());

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		mediaView = new MediaView(mediaPlayer);

	}

	

	@FXML
	public void playpause() throws MalformedURLException {
		if (playpauseButton.isSelected()) {
			if (musicFile != null) {
                 totalTimeOfMusic=mediaPlayer.getTotalDuration().toSeconds();
         System.out.println(totalTimeOfMusic);
				durationLabel.setText(String.valueOf(new DecimalFormat("#.00")
						.format(mediaPlayer.getTotalDuration().toMinutes())));// duration label
																				

				// for set value for initial
				volumeSlider.setValue(40);
				mediaPlayer.setVolume(volumeSlider.getValue() / 100);

				imageFilePausePlay = new File("images/pause.jpg");
				localUrl = imageFilePausePlay.toURI().toURL().toString();
				Image image2 = new Image(localUrl);
				playPuseImage.setImage(image2);
				mediaPlayer.play();

		
				volumeSlider.valueProperty().addListener((Observable) -> {

					mediaPlayer.setVolume(volumeSlider.getValue() / 100);

				});
				
				// seek slider


				mediaPlayer.currentTimeProperty().addListener((Observable)->{
					if(seekSlider.isValueChanging()){
						mediaPlayer.seek(Duration.seconds((seekSlider.getValue()*(totalTimeOfMusic)/100)));
					}
					if(seekSlider.isPressed()){
						mediaPlayer.seek(Duration.seconds((seekSlider.getValue()*(totalTimeOfMusic)/100)));
					}
							//updateValues();
								seekSlider.setValue((mediaPlayer.getCurrentTime().toSeconds()*100)/totalTimeOfMusic);
								System.out.println("ok"+mediaPlayer.getCurrentTime().toSeconds());
							   playTime.setText(String.valueOf(new DecimalFormat("#0.00").format(mediaPlayer.getCurrentTime().toMinutes()))+"  /");
						});

				mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);// for run
																	// infinite
																	// time

				// mediaPlayer.setOnPlaying(new Runnable() {
				// public void run() {
				// System.out.println("playing");
				// updateValues();
				// }
				// });

				System.out.println(mediaPlayer.getStartTime());

				System.out.println();
			} else {

			}
		} else {
			if (musicFile != null) {
				imageFilePausePlay = new File("images/Button-Play-icon.png");
				localUrl = imageFilePausePlay.toURI().toURL().toString();
				Image image2 = new Image(localUrl);
				playPuseImage.setImage(image2);
				durationLabel.setText(String.valueOf(new DecimalFormat("#.00")
						.format(mediaPlayer.getTotalDuration().toMinutes())));// duration
																				// label
				mediaPlayer.pause();

			}
		}

	}

	@FXML
	public void next() {

		System.out.println("next");
	}

	@FXML
	public void dragDropped() {
		System.out.println("droped");
	}

	@FXML
	public void folderOpen() {
		System.out.println("folder");
	}
	@FXML
	public void dragDone() {
		System.out.println("drage done");
	}

	@FXML
	public void dragEntered() {
		System.out.println("drage entered");
	}

	@FXML
	public void back() {
		System.out.println("previos");
		

	}
	@FXML
	public void dragDetected() {
		System.out.println("dreg Detected");
		

	}


}
