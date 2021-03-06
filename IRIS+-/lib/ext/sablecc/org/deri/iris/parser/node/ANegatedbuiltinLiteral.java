/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.deri.iris.parser.node;

import org.deri.iris.parser.analysis.*;

@SuppressWarnings("nls")
public final class ANegatedbuiltinLiteral extends PLiteral
{
    private TTNot _tNot_;
    private PBuiltin _builtin_;

    public ANegatedbuiltinLiteral()
    {
        // Constructor
    }

    public ANegatedbuiltinLiteral(
        @SuppressWarnings("hiding") TTNot _tNot_,
        @SuppressWarnings("hiding") PBuiltin _builtin_)
    {
        // Constructor
        setTNot(_tNot_);

        setBuiltin(_builtin_);

    }

    @Override
    public Object clone()
    {
        return new ANegatedbuiltinLiteral(
            cloneNode(this._tNot_),
            cloneNode(this._builtin_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANegatedbuiltinLiteral(this);
    }

    public TTNot getTNot()
    {
        return this._tNot_;
    }

    public void setTNot(TTNot node)
    {
        if(this._tNot_ != null)
        {
            this._tNot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._tNot_ = node;
    }

    public PBuiltin getBuiltin()
    {
        return this._builtin_;
    }

    public void setBuiltin(PBuiltin node)
    {
        if(this._builtin_ != null)
        {
            this._builtin_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._builtin_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._tNot_)
            + toString(this._builtin_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._tNot_ == child)
        {
            this._tNot_ = null;
            return;
        }

        if(this._builtin_ == child)
        {
            this._builtin_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._tNot_ == oldChild)
        {
            setTNot((TTNot) newChild);
            return;
        }

        if(this._builtin_ == oldChild)
        {
            setBuiltin((PBuiltin) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
