import ReactPlayer from "react-player";
import './App.css';

function App() {
    return (
        <div className="App">
            <ReactPlayer
                url="https://www.youtube.com/watch?v=KsZ6tROaVOQ"
                playing={false}
                volume={0.5}
                controls/>
        </div>
    );
}

export default App;
