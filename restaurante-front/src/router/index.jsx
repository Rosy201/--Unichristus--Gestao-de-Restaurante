import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from '../pages/Login'
import Inicio from '../pages/Inicio'

export default function AppRoutes() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/home" element={<Inicio />} />
      </Routes>
    </BrowserRouter>
  )
}
