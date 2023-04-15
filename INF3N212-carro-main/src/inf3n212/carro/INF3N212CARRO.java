/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inf3n212.carro;

import controller.CCarro;
import controller.CPessoa;
import java.util.InputMismatchException;
import java.util.Scanner;
import model.Carro;
import model.Pessoa;
import util.Validadores;

/**
 *
 * @author 631510300
 */
public class INF3N212CARRO {

    public static final String VERMELHO = "\u001B[31m";
    public static final String RESET = "\u001B[30m";
    public static final String VERDE = "\u001B[32m";
    public static final String AZUL = "	\u001B[36m";

    public static CPessoa cadPessoa = new CPessoa();

    public static CCarro cadCarro = new CCarro();
    static Scanner leia = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        cadPessoa.mockPessoas();
        cadCarro.mockCarros();
        int opM = 212;
        int oopSM = 212;

        do {
            System.out.println("--Sistema de Cadastro--");
            menuP();
            opM = leiaNumInt();
            switch (opM) {
                case 1:
                case 2:
                    do {
                        subMenu(opM);
                        oopSM = leiaNumInt();
                        switch (oopSM) {
                            case 1:
                                if (opM == 1) {
                                    cadastrarPessoa();
                                } else {
                                    cadastrarCarro();
                                }
                                break;
                            case 2:
                                if (opM == 1) {
                                    editarPessoa();
                                } else {
                                    editarCarro();
                                }

                                break;
                            case 3:
                                System.out.println("Lista");
                                if (opM == 1) {
                                    listarPessoa();
                                } else {
                                    listarCarro();
                                }

                                break;
                            case 4:
                                System.out.println("Deleta1");
                                if (opM == 1) {
                                    deletarPessoa();
                                } else {
                                    deletarCarro();
                                }

                                break;
                            case 0:

                                break;
                            default:
                                System.out.println(VERMELHO + "opção Inválida, tente novamente" + RESET);
                        }//fim Switch SUBMENU
                    } while (oopSM != 0);
                    break;

                case 3:

                    break;
                case 0:
                    System.out.println("Aplicação encerrada pelo ananá");
                    break;
                default:
                    System.out.println(VERMELHO + "Opção inválida, tente novamente!" + RESET);
            }

        } while (opM != 0);
    }//fim do main

    public static int leiaNumInt() {
        Scanner leiaNum = new Scanner(System.in);
        try {
            return leiaNum.nextInt();

        } catch (InputMismatchException i) {
            System.out.println(VERMELHO + "Erro: " + i.getMessage() + "\nTente novamente" + RESET);
            leiaNumInt();
        }
        return 69;
    }

    public static void menuP() {
        System.out.println(VERDE + "--Menu Principal--" + RESET);
        System.out.println("1- Gerir Pessoa");
        System.out.println("2- Gerir Carro");
        System.out.println("0 - sair");
        System.out.print("Digite aqui:");
    }//fim menuP

    public static void subMenu(int opm) {
        String subM = null;
        if (opm == 1) {
            subM = "Pessoa";
        }
        if (opm == 2) {
            subM = "Carro";
        }

        System.out.println(VERDE + "--Ger. " + subM + "---" + RESET);
        System.out.println("1 - Cadastrar" + subM);
        System.out.println("2- Editar" + subM);
        System.out.println("3- Listar" + subM + "s");
        System.out.println("4 - Deletar" + subM);
        System.out.println("0 - voltar");
        System.out.print("Digite aqui:");
    }//fim subMenu

    private static void cadastrarPessoa() {
        System.out.println(AZUL + "--Cadastro de Pessoa--" + RESET);
        int idPessoa;
        String nome;
        String cpf;
        String endereco;
        String telefone;
        boolean tcpf = true;
        do {
            System.out.print("Digite o CPF\t");
            cpf = leia.nextLine();
            tcpf = Validadores.isCPF(cpf);
            if (tcpf) {
                if (cadPessoa.getPessoaCPF(cpf) != null) {
                    System.out.println(VERMELHO + "CPF já cadastrado");
                    System.out.println("1 - Tentar novamente");
                    System.out.println("2 - Cancelar cadastro");
                    System.out.print("Digite aqui:\t");
                    int op = leiaNumInt();
                    if (op == 2) {
                        return;
                    }
                } else {
                    tcpf = false;
                }
            } else {
                System.out.println(VERMELHO + "CPF inválido" + RESET);
                System.out.println("1 - Tentar novamente");
                System.out.println("2 - Cancelar cadastro");
                System.out.print("Digite aqui:\t");
                int op = leiaNumInt();
                if (op == 2) {
                    return;
                }
            }
        } while (tcpf);
        System.out.print("Informe o nome: ");
        nome = leia.nextLine();
        System.out.print("Informe o endereço: ");
        endereco = leia.nextLine();
        System.out.print("Informe o Telefone: ");
        telefone = leia.nextLine();
        idPessoa = cadPessoa.geraID();
        Pessoa p = new Pessoa(idPessoa, nome, cpf, endereco, telefone);
        cadPessoa.addPessoa(p);
        System.out.println(VERDE + p.getNome() + " cadastrado com sucesso!" + RESET);
    }

    private static void cadastrarCarro() {
        System.out.println(AZUL + "--Cadastar Carro--" + RESET);
        boolean pCarro = true;
        String placa;
        String marca;
        String modelo;
        int anoFab;
        int anoMod;
        String cor;
        String tpCambio;
        String combustivel;
        Pessoa proprietario;
        do {
            System.out.print("Informe a placa: ");
            placa = leia.nextLine();
            placa = placa.toUpperCase();
            pCarro = Validadores.validarPlaca(placa);
            if (pCarro) {
                Carro Carro = cadCarro.getCarroPlaca(placa);
                if (Carro == null) {
                    System.out.print("Informe a Marca: ");
                    marca = leia.nextLine();
                    System.out.print("Informe o Modelo ");
                    modelo = leia.nextLine();
                    do {
                        System.out.print("Informe o ano de Fabricação");
                        anoFab = leiaNumInt();
                        System.out.print("Informe o ano do Modelo");
                        anoMod = leiaNumInt();
                        if (!Validadores.validarAnoCarro(anoFab, anoMod)) {
                            System.out.println(VERMELHO + "Ano inválido, tente novamente" + RESET);
                        }
                    } while (!Validadores.validarAnoCarro(anoFab, anoMod));
                    System.out.print("Informe a cor do veículo: ");
                    cor = leia.nextLine();
                    System.out.print("Informe o tipo de câmbio: ");
                    tpCambio = leia.nextLine();
                    System.out.print("Informe o combustivel: ");
                    combustivel = leia.nextLine();
                    System.out.print("Informe a cor do veículo: ");
                    cor = leia.nextLine();

                    do {
                        System.out.print("Informe o CPF do proprietário: ");
                        String cpf = leia.nextLine();
                        proprietario = cadPessoa.getPessoaCPF(cpf);
                        if (proprietario == null) {
                            System.out.println(VERMELHO + "CPF não cadastrado, tente novamente" + RESET);
                        } else {
                            System.out.println("Pessoa selecionada: " + proprietario.getNome());
                            System.out.println("Este é o proprietário correto?");
                            System.out.println("1-Sim | 2-Não");
                            System.out.print("Digite aqui: ");
                            int op = leiaNumInt();
                            if (op == 2) {
                                proprietario = null;
                            } else {
                                System.out.println("Tente outro Proprietário");
                            }
                        }
                    } while (proprietario == null);
                    pCarro = false;
                    Carro c = new Carro(placa, marca, modelo, anoFab, anoMod, cor, tpCambio, combustivel, proprietario);
                    cadCarro.addCarro(c);
                    System.out.println(VERDE + "Carro Cadastrado com Sucesso" + RESET);
                } else {
                    System.out.println(VERMELHO + "Placa já cadastrada" + RESET);
                    pCarro = false;

                }
            } else {
                System.out.println(VERMELHO + "Placa inválida! Tenta novamente" + RESET);
                pCarro = true;

            }

        } while (pCarro);
    }

    private static void editarPessoa() {
        System.out.println(AZUL + "--Editar Pessoa--" + RESET);
        boolean isCPF;
        do {
            System.out.println("Informe o CPF da Pessoa a ser editado: ");
            String cpf = leia.nextLine();
            isCPF = Validadores.isCPF(cpf);
            if (isCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);

                if (p != null) {
                    do {

                        System.out.println("Quais dados de " + p.getNome() + "deseja alterar?");
                        System.out.println("1-Nome | 2-Endereço | 3-Telefone | 4-Todos | 0-Voltar");
                        System.out.print("Digite a opção: ");
                        int op = leiaNumInt();
                        if (op == 1 | op == 4) {
                            System.out.println("Informe o novo nome:");
                            p.setNome(leia.nextLine());
                        }
                        if (op == 2 | op == 4) {
                            System.out.println("Informe o novo endereço:");
                            p.setEndereco(leia.nextLine());
                        }
                        if (op == 3 | op == 4) {
                            System.out.println("Informe o novo Telefone:");
                            p.setTelefone(leia.nextLine());

                        }
                        if (op == 0) {
                            System.out.println(VERMELHO + "Operação cancelada pelo Usuário" + RESET);
                            isCPF = false;
                        }
                        if (op < 0 || op > 4) {
                            System.out.println(VERMELHO + "Opção inválida" + RESET);

                        }
                    } while (isCPF); //fim do p!=null
                } else {
                    System.out.println(VERMELHO + "CPF não cadastrado" + RESET);
                    isCPF = false;
                }

            } else {
                System.out.println(VERMELHO + "CPF inválido" + RESET);
                System.out.println("Deseja tentar novamente?");
                System.out.println("1-SIm | 1-não");
                int op = leiaNumInt();
                if (op == 1) {
                    isCPF = true;

                } else {
                    isCPF = false;
                }
            }
        } while (isCPF);
    }

    private static void editarCarro() {
        System.out.println(AZUL + "--Editar Carro--");
        boolean isPlaca;
        do {
            System.out.print("Informe a placa do carro: ");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            isPlaca = Validadores.validarPlaca(placa);
            if (isPlaca) {
                Carro c;
                c = cadCarro.getCarroPlaca(placa);
                if (c != null) {
                    System.out.println(c.toString());
                    System.out.println("O que deseja alterar?");
                    System.out.println("1- cor");
                    System.out.println("2- Tipo de câmbio");
                    System.out.println("3- Tipo de combustivel");
                    System.out.println("4- proprietário");
                    System.out.println("5- Todos");
                    System.out.println("0- Cancelar");
                    System.out.print("Digite aqui: ");
                    int op = leiaNumInt();
                    if (op == 1 || op == 5) {
                        System.out.print("Informe a nova cor");
                        c.setCor(leia.nextLine().toUpperCase());
                    }
                    if (op == 2 || op == 5) {
                        System.out.print("Informe o novo câmbio");
                        c.setTpCambio(leia.nextLine().toUpperCase());
                    }
                    if (op == 3 || op == 5) {
                        System.out.print("Informe o novo combustido");
                        c.setCombustivel(leia.nextLine().toUpperCase());
                    }
                    if (op == 4 || op == 5) {
                        boolean isCPF;
                        do {
                            System.out.print("Informe o CPF do Proprietário");
                            String cpf = leia.nextLine();
                            isCPF = Validadores.isCPF(cpf);
                            if (isCPF) {
                                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                                if (p != null) {
                                    System.out.println("Pessoa selecionada " + p.getNome());
                                    System.out.println("Está correto?");
                                    System.out.println("1-SIM | 2-NÃO");
                                    System.out.println("Digite aqui: ");
                                    op = leiaNumInt();
                                    if (op == 1) {
                                        isCPF = false;
                                        c.setProprietario(p);
                                    }

                                } else {
                                    System.out.println(VERMELHO + "CPF não encontrado" + RESET);
                                    System.out.println("1- Cadastrar | 2 tentar novamente");
                                    System.out.print("Digite aqui: ");
                                    int op2 = leiaNumInt();
                                    if (op2 == 1) {
                                        cadastrarPessoa();
                                    }
                                }
                            }else{
                                System.out.println(VERMELHO+"CPF inválido, tente novamente"+RESET);
                                isCPF=true;
                            }
                        } while (isCPF);

                    }
                    if (op == 0) {
                        System.out.println(VERMELHO + "Operação cancelada pelo usuário" + RESET);
                        isPlaca = false;

                    }
                    if (op < 0 || op > 5) {
                        System.out.println(VERMELHO + "Opção inválida" + RESET);
                    }
                    isPlaca = false;

                } else {
                    System.out.println(VERMELHO + "Placa não cadastrada" + RESET);
                    isPlaca = true;
                }
            } else {
                System.out.println(VERMELHO + "Placa inválida" + RESET);
                System.out.println("Deseja tentar novamente?");
                System.out.println("1-SIM | 2-NÃO");
                System.out.print("Digita aqui");
                int op = leiaNumInt();
                if (op == 1) {
                    isPlaca = true;
                }
            }
        } while (isPlaca);
    }

    private static void listarPessoa() {
        System.out.println(AZUL + "-- Lista de Pessoas" + RESET);
        for (Pessoa pessoa : cadPessoa.getPessoa()) {
            System.out.println(pessoa.toString());
        }
    }

    private static void listarCarro() {
        System.out.println(AZUL + "-- Lista de Carros" + RESET);
        for (Carro carro : cadCarro.getCarros()) {
            System.out.println(carro.toString());

        }
    }

    private static void deletarPessoa() {
        System.out.println(AZUL + "--Deletar Pessoa--" + RESET);
        boolean delCPF = false;
        do {
            System.out.println("Informe o CPF da Pessoa a ser deletada: ");
            String cpf = leia.nextLine();
            delCPF = Validadores.isCPF(cpf);
            if (delCPF) {
                Pessoa p = cadPessoa.getPessoaCPF(cpf);
                if (p != null) {
                    System.out.println("Deseja realmente deletar essa pessoa?");
                    System.out.println("1-sim | 2-não");
                    int opm = leiaNumInt();
                    if (opm == 1) {
                        cadPessoa.removePessoa(p);
                        System.out.println(VERDE + "Pessoa deletada com sucesso" + RESET);
                        delCPF = false;
                    } else {
                        System.out.println("Operação cancelada pelo usuário");
                        delCPF = false;
                    }
                } else {
                    System.out.println("CPF não cadastrado");
                    System.out.println("Deseja tentar novamente?");
                    System.out.println("1-sim | 2-não");
                    int opm = leiaNumInt();
                    if (opm == 1) {
                        delCPF = true;

                    } else {
                        delCPF = false;
                    }
                }
            } else {
                System.out.println(VERMELHO + "CPF inválido" + RESET + "\n Tente novamente");
                delCPF = true;
            }
        } while (delCPF);
    }

    private static void deletarCarro() {
        System.out.println(AZUL + "--Deletar Pessoa--");
        boolean delCarro = false;
        do {
            System.out.print("Informe a Placa do carro a ser deletado: ");
            String placa = leia.nextLine();
            placa = placa.toUpperCase();
            delCarro = Validadores.validarPlaca(placa);
            if (delCarro) {
                Carro c = cadCarro.getCarroPlaca(placa);
                if (c != null) {
                    System.out.println("Deseja realemnte deletar esse carro?");
                    System.out.println("1-Sim | 2-Não");
                    int opm = leiaNumInt();
                    if (opm == 1) {
                        cadCarro.removeCarro(c);
                        System.out.println(VERDE + "Carro deletado com sucesso!" + RESET);
                        delCarro = false;
                    } else {
                        System.out.println(VERMELHO + "Operação cancelada pelo usuário" + RESET);
                        System.out.println("Deseja tentar novamente?");
                        System.out.println("1-sim | 2-não");
                        int op = leiaNumInt();
                        if (op == 1) {
                            delCarro = true;
                        } else {
                            System.out.println(VERMELHO + "Operação cancelada pelo usuário" + RESET);
                            delCarro = false;
                        }
                    }
                } else {
                    System.out.println(VERMELHO + "Placa Inválida" + RESET + "\n Tente novamente");
                    delCarro = true;
                }
            }

        } while (delCarro);
    }

}//fim da classe
