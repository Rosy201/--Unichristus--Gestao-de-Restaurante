import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

export default function Login() {
  const [eLogin, funcaoELogin] = useState(true)
  const navegador = useNavigate()

  const alterarForma = () => funcaoELogin(false)

  const enviarFormulario = (e) => {
    e.preventDefault()
    navegador('/Inicio')
  }

  return (
    <div className="h-screen bg-gray-100">
      
      <h1 className="p-6 text-2xl font-bold text-blue-700">
        Restaurante
      </h1>

      <div className="flex justify-center items-center h-[calc(100vh-96px)]">
        <form onSubmit={enviarFormulario} className="bg-white p-8 rounded shadow-md w-80">
          <h2 className="text-2xl font-bold mb-6 text-center">
            {eLogin ? 'Acesse sua conta.' : 'Cadastre-se'}
          </h2>

          {eLogin && (
            <p
              className="mt-4 text-sm text-center text-blue-600 cursor-pointer"
              onClick={alterarForma}
            >
              Não tem conta? Cadastre-se
            </p>
          )}

          {!eLogin && (
            <>
              <input
                type="text"
                placeholder="Nome completo"
                className="w-full mb-4 p-2 border rounded"
                required
              />
              <input
                type="text"
                placeholder="Usuário"
                className="w-full mb-4 p-2 border rounded"
                required
              />
            </>
          )}

          <input
            type="email"
            placeholder="Email"
            className="w-full mb-4 p-2 border rounded"
            required
          />
          <input
            type="password"
            placeholder="Senha"
            className="w-full mb-4 p-2 border rounded"
            required
          />

          <button className="w-full bg-blue-600 text-white py-2 rounded hover:bg-blue-700">
            {eLogin ? 'Entrar' : 'Adicionar usuário'}
          </button>
        </form>
      </div>
    </div>
  )
}
