/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciarproduto;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.beans.Beans;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.SimpleFormatter;
import javax.persistence.RollbackException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Juninho
 */
public class TelaDeEntrada extends JPanel {
    
    private static JFrame frame;
    public TelaDeEntrada() {
        initComponents();
        if (!Beans.isDesignTime()) {
            entityManager.getTransaction().begin();
        }
        jTextField1.setEnabled(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        entityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("junior?zeroDateTimeBehavior=convertToNullPU").createEntityManager();
        query = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM EntradaDeProduto e");
        list = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : org.jdesktop.observablecollections.ObservableCollections.observableList(query.getResultList());
        estoqueQuery = java.beans.Beans.isDesignTime() ? null : entityManager.createQuery("SELECT e FROM Estoque e");
        estoqueList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : estoqueQuery.getResultList();
        masterScrollPane = new javax.swing.JScrollPane();
        masterTable = new javax.swing.JTable();
        newButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        detailScrollPane = new javax.swing.JScrollPane();
        detailTable = new javax.swing.JTable();
        saveButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();
        deleteDetailButton = new javax.swing.JButton();
        newDetailButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();

        FormListener formListener = new FormListener();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, list, masterTable);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${local}"));
        columnBinding.setColumnName("Local");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dataEntrada}"));
        columnBinding.setColumnName("Data Entrada");
        columnBinding.setColumnClass(java.util.Date.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${funcionarioCodFuncionario}"));
        columnBinding.setColumnName("Funcionario Cod Funcionario");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        masterScrollPane.setViewportView(masterTable);

        add(masterScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 20, 0, 0));

        newButton.setText("Nova Entrada");
        newButton.addActionListener(formListener);
        add(newButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 110, -1));

        deleteButton.setText("Delete");

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteButton.addActionListener(formListener);
        add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 0, 0, 0));

        org.jdesktop.beansbinding.ELProperty eLProperty = org.jdesktop.beansbinding.ELProperty.create("${selectedElement.detEntradaList}");
        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, eLProperty, detailTable);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${detEntradaPK.produtoCodProduto}"));
        columnBinding.setColumnName("codigo do produto");
        columnBinding.setColumnClass(Integer.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricao}"));
        columnBinding.setColumnName("Descricao");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdeCompra}"));
        columnBinding.setColumnName("Qtde Entrada");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${vlrCompra}"));
        columnBinding.setColumnName("Vlr Entrada");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tamanho}"));
        columnBinding.setColumnName("Tamanho");
        columnBinding.setColumnClass(String.class);
        columnBinding.setEditable(false);
        jTableBinding.setSourceUnreadableValue(java.util.Collections.emptyList());
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();
        detailScrollPane.setViewportView(detailTable);

        add(detailScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 450, 140));

        saveButton.setText("Salvar");
        saveButton.addActionListener(formListener);
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 110, -1));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(formListener);
        add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 20, 0, 0));

        deleteDetailButton.setText("Delete");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, detailTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), deleteDetailButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        deleteDetailButton.addActionListener(formListener);
        add(deleteDetailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 13, 0, 0));

        newDetailButton.setText("Novo Detalhe");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), newDetailButton, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        newDetailButton.addActionListener(formListener);
        add(newDetailButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 110, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(0));

        jLabel1.setText("Funcionario:");

        jLabel2.setText("Local:");

        jLabel3.setText("Data da entrada:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.funcionarioCodFuncionario}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jTextField2.setBackground(new java.awt.Color(255, 255, 0));
        jTextField2.setEnabled(false);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.local}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jTextField3, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.dataEntrada}"), jDateChooser1, org.jdesktop.beansbinding.BeanProperty.create("date"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, masterTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jDateChooser1, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jLabel6.setText("Quantidade:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, detailTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.qtdeCompra}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, detailTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jTextField4, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        jTextField4.addKeyListener(formListener);

        jLabel7.setText("Valor:");

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, detailTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.vlrCompra}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);
        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, detailTable, org.jdesktop.beansbinding.ELProperty.create("${selectedElement != null}"), jTextField5, org.jdesktop.beansbinding.BeanProperty.create("enabled"));
        bindingGroup.addBinding(binding);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 20, 450, 190));

        jLabel4.setText("jLabel4");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 0, 0));

        jLabel5.setText("jLabel5");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, 0, 0));

        jButton1.setText("Voltar");
        jButton1.addActionListener(formListener);
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, -1, -1));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, estoqueList, jTable1);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${descricaoEstoque}"));
        columnBinding.setColumnName("Descricao Estoque");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tamanho}"));
        columnBinding.setColumnName("Tamanho");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${local}"));
        columnBinding.setColumnName("Local");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${data}"));
        columnBinding.setColumnName("Data");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${tipo}"));
        columnBinding.setColumnName("Tipo");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${qtdeEstoque}"));
        columnBinding.setColumnName("Qtde Estoque");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${valor}"));
        columnBinding.setColumnName("Valor");
        columnBinding.setColumnClass(Double.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${saldoEstoque}"));
        columnBinding.setColumnName("Saldo Estoque");
        columnBinding.setColumnClass(Integer.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 0, 0));

        jButton2.setText("Visualizar Entrada");
        jButton2.addActionListener(formListener);
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, -1, -1));

        bindingGroup.bind();
    }

    // Code for dispatching events from components to event handlers.

    private class FormListener implements java.awt.event.ActionListener, java.awt.event.KeyListener {
        FormListener() {}
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (evt.getSource() == newButton) {
                TelaDeEntrada.this.newButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteButton) {
                TelaDeEntrada.this.deleteButtonActionPerformed(evt);
            }
            else if (evt.getSource() == saveButton) {
                TelaDeEntrada.this.saveButtonActionPerformed(evt);
            }
            else if (evt.getSource() == refreshButton) {
                TelaDeEntrada.this.refreshButtonActionPerformed(evt);
            }
            else if (evt.getSource() == deleteDetailButton) {
                TelaDeEntrada.this.deleteDetailButtonActionPerformed(evt);
            }
            else if (evt.getSource() == newDetailButton) {
                TelaDeEntrada.this.newDetailButtonActionPerformed(evt);
            }
            else if (evt.getSource() == jButton1) {
                TelaDeEntrada.this.jButton1ActionPerformed(evt);
            }
            else if (evt.getSource() == jButton2) {
                TelaDeEntrada.this.jButton2ActionPerformed(evt);
            }
        }

        public void keyPressed(java.awt.event.KeyEvent evt) {
            if (evt.getSource() == jTextField4) {
                TelaDeEntrada.this.jTextField4KeyPressed(evt);
            }
        }

        public void keyReleased(java.awt.event.KeyEvent evt) {
        }

        public void keyTyped(java.awt.event.KeyEvent evt) {
        }
    }// </editor-fold>//GEN-END:initComponents

    
    private void deleteDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDetailButtonActionPerformed
        int index = masterTable.getSelectedRow();
        gerenciarproduto.EntradaDeProduto e = list.get(masterTable.convertRowIndexToModel(index));
        Collection<gerenciarproduto.DetEntrada> ds = e.getDetEntradaList();
        int[] selected = detailTable.getSelectedRows();
        List<gerenciarproduto.DetEntrada> toRemove = new ArrayList<gerenciarproduto.DetEntrada>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            selected[idx] = detailTable.convertRowIndexToModel(selected[idx]);
            int count = 0;
            Iterator<gerenciarproduto.DetEntrada> iter = ds.iterator();
            while (count++ < selected[idx]) {
                iter.next();
            }
            gerenciarproduto.DetEntrada d = iter.next();
            toRemove.add(d);
            entityManager.remove(d);
        }
        ds.removeAll(toRemove);
        masterTable.clearSelection();
        masterTable.setRowSelectionInterval(index, index);
    }//GEN-LAST:event_deleteDetailButtonActionPerformed
    
    private void newDetailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newDetailButtonActionPerformed
        
        entityManager.getTransaction().commit();
        entityManager.getTransaction().begin();
        
        int index = masterTable.getSelectedRow();
        gerenciarproduto.EntradaDeProduto e = list.get(masterTable.convertRowIndexToModel(index));
        Collection<gerenciarproduto.DetEntrada> ds = e.getDetEntradaList();
        if (ds == null) {
            ds = new LinkedList<gerenciarproduto.DetEntrada>();
            e.setDetEntradaList((List) ds);
        }
        gerenciarproduto.DetEntrada d = new gerenciarproduto.DetEntrada();
        DetEntradaPK dpk = new DetEntradaPK();
        dpk.setCompraCodEntrada(e.getCodEntrada());
        d.setDetEntradaPK(dpk);
        ImportarProd ip=new ImportarProd(null, true);
        ip.recebeObjeto(d);
        ip.setVisible(true);
        entityManager.persist(d);
        d.setEntradaDeProduto(e);
        ds.add(d);
        masterTable.clearSelection();
        masterTable.setRowSelectionInterval(index, index);
        int row = ds.size() - 1;
        detailTable.setRowSelectionInterval(row, row);
        detailTable.scrollRectToVisible(detailTable.getCellRect(row, 0, true));
        jTextField5.requestFocus();
    }//GEN-LAST:event_newDetailButtonActionPerformed
    

    @SuppressWarnings("unchecked")
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().begin();
        java.util.Collection data = query.getResultList();
        for (Object entity : data) {
            entityManager.refresh(entity);
        }
        list.clear();
        list.addAll(data);
    }//GEN-LAST:event_refreshButtonActionPerformed
    
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int[] selected = masterTable.getSelectedRows();
        List<gerenciarproduto.EntradaDeProduto> toRemove = new ArrayList<gerenciarproduto.EntradaDeProduto>(selected.length);
        for (int idx = 0; idx < selected.length; idx++) {
            gerenciarproduto.EntradaDeProduto e = list.get(masterTable.convertRowIndexToModel(selected[idx]));
            toRemove.add(e);
            entityManager.remove(e);
        }
        list.removeAll(toRemove);
    }//GEN-LAST:event_deleteButtonActionPerformed
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        gerenciarproduto.EntradaDeProduto e = new gerenciarproduto.EntradaDeProduto();
        entityManager.persist(e);
        list.add(e);
        int row = list.size() - 1;
        masterTable.setRowSelectionInterval(row, row);
        masterTable.scrollRectToVisible(masterTable.getCellRect(row, 0, true));
        jTextField1.setText(jLabel4.getText());
        jTextField2.setText(jLabel5.getText());
    }//GEN-LAST:event_newButtonActionPerformed
    
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        try {
            entityManager.getTransaction().commit();
            entityManager.getTransaction().begin();
        } catch (RollbackException rex) {
            rex.printStackTrace();
            entityManager.getTransaction().begin();
            List<gerenciarproduto.EntradaDeProduto> merged = new ArrayList<gerenciarproduto.EntradaDeProduto>(list.size());
            for (gerenciarproduto.EntradaDeProduto e : list) {
                merged.add(entityManager.merge(e));
            }
            list.clear();
            list.addAll(merged);
        }
        EntradaDeProduto e = new EntradaDeProduto();
        DetEntrada d = new DetEntrada();
        e.setDataEntrada((Date) masterTable.getValueAt(masterTable.getSelectedRow(),1));
        e.setLocal((String) masterTable.getValueAt(masterTable.getSelectedRow(),0));
        d.setDescricao((String) detailTable.getValueAt(detailTable.getSelectedRow(),1));
        d.setQtdeCompra((Integer) detailTable.getValueAt(detailTable.getSelectedRow(),2));
        d.setTamanho((String) detailTable.getValueAt(detailTable.getSelectedRow(),4));
        d.setVlrCompra((Double) detailTable.getValueAt(detailTable.getSelectedRow(),3));
        EntradaNoEstoque(d, e);
        JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
    }//GEN-LAST:event_saveButtonActionPerformed
    public String EntradaNoEstoque(DetEntrada detEntrada,EntradaDeProduto entradaDeProduto){
         Conexao c=new Conexao();
        estoqueQuery=entityManager.createNamedQuery("Estoque.findByVerificaEstoque");
        estoqueQuery.setParameter("descricaoEstoque", detEntrada.getDescricao());
        estoqueQuery.setParameter("tamanho", detEntrada.getTamanho());
        List <Estoque> data = estoqueQuery.getResultList();
        Date d = entradaDeProduto.getDataEntrada();
        
        if(data.size() > 0)
        {
            try
                {
                    estoqueQuery=entityManager.createNamedQuery("Estoque.findByVerificaEstoque");
                    estoqueQuery.setParameter("descricaoEstoque", detEntrada.getDescricao());
                    estoqueQuery.setParameter("tamanho", detEntrada.getTamanho());
                    List <Estoque> dat = estoqueQuery.getResultList();
                    int saldo=(dat.get(0).getSaldoEstoque());
                    String sentenca;
                    
                    sentenca = "INSERT INTO estoque VALUES (NULL,'"+detEntrada.getDescricao()+"',"+detEntrada.getQtdeCompra()+",'"+entradaDeProduto.getDataEntrada()+"', 'entrada', "+detEntrada.getVlrCompra()+", "+(saldo+=detEntrada.getQtdeCompra())+", '"+detEntrada.getTamanho()+"', '"+entradaDeProduto.getLocal()+"')";
                    return c.atualizarBanco(sentenca);
                }
            catch(Exception e)
                {
                    return e.getMessage();
                }
        }else{
           try
                {
                    String sentenca;
                    
                    sentenca = "INSERT INTO estoque VALUES (NULL,'"+detEntrada.getDescricao()+"','"+detEntrada.getQtdeCompra()+"',NULL, 'entrada', '"+detEntrada.getVlrCompra()+"', '"+detEntrada.getQtdeCompra()+"', '"+detEntrada.getTamanho()+"', '"+entradaDeProduto.getLocal()+"')";
                    return c.atualizarBanco(sentenca);
                }
            catch(Exception e)
                {
                    return e.getMessage();
                }
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frame.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){ 
        saveButtonActionPerformed(null);
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String args[] = new String[1];
        args[0] = "";
        MostrarEntrada.main(args);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteDetailButton;
    private javax.swing.JScrollPane detailScrollPane;
    private javax.swing.JTable detailTable;
    private javax.persistence.EntityManager entityManager;
    private java.util.List<gerenciarproduto.Estoque> estoqueList;
    private javax.persistence.Query estoqueQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private static javax.swing.JLabel jLabel4;
    private static javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private java.util.List<gerenciarproduto.EntradaDeProduto> list;
    private javax.swing.JScrollPane masterScrollPane;
    private javax.swing.JTable masterTable;
    private javax.swing.JButton newButton;
    private javax.swing.JButton newDetailButton;
    private javax.persistence.Query query;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    public static void main(final String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaDeEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDeEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDeEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDeEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame = new JFrame();
                frame.setContentPane(new TelaDeEntrada());
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
                jLabel4.setText(args[0]);
                jLabel5.setText(args[1]);
                frame.setLocationRelativeTo(null);
                frame.setTitle("Controle de entrada");
            }
        });
    }
}
