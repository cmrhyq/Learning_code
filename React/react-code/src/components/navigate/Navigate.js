import {Link, Route, Routes} from "react-router-dom";
import HomePage from "./HomePage";
import ContentPage from "./ContentPage";
import AboutPage from "./AboutPage";
import "../../App.css"

export default function Navigate() {
    return (
        <div>
            <nav className="nav">
                <Link to="/" className="nav-item">Homepage</Link>
                <Link to="/content" className="nav-item">Content</Link>
                <Link to="/about" className="nav-item">About</Link>
            </nav>
            <Routes>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/content" element={<ContentPage/>}/>
                <Route path="/about" element={<AboutPage/>}/>
            </Routes>
        </div>
    )
}
